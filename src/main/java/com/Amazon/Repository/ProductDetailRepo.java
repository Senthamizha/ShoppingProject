package com.Amazon.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Amazon.Model.CategoryList;
import com.Amazon.Model.ItemList;

@Component
@Repository
@Transactional
public class ProductDetailRepo extends CommonRepo{
	Logger logger = LoggerFactory.getLogger(ProductDetailRepo.class);
	public void saveAllProducts() {
		logger.info("Repository:ProductDetailRepo: Entered saveAllProducts()");
		try {
			Scanner categoryFileScanner = new Scanner(new File("G://Docs/categorylist.csv"));
	        FileInputStream file = new FileInputStream(new File("G://Docs/itemlist.xlsx"));
	        Workbook workbook = new XSSFWorkbook(file);

	        List<CategoryList> categoryList = new ArrayList<>();
	        
	        categoryFileScanner.next();
	        while (categoryFileScanner.hasNext()) {
	            String[] arr = categoryFileScanner.next().split(",");
	            CategoryList myCategory = new CategoryList();
	            myCategory.setCategoryId(arr[0]);
	            myCategory.setCategoryName(arr[1]);
	            myCategory.setImageUrl(arr[2]);
	            categoryList.add(myCategory);
	        }

	        Sheet sheet = workbook.getSheetAt(0);

	        for (int i=0;i< 50;i++) {
	        	logger.info("Repository:ProductDetailsRepo: Iterating Item list");
	        	ItemList item = new ItemList();
	            Row row = sheet.getRow(i);
	            item.setCategoryId(Integer.toString((int)row.getCell(0).getNumericCellValue()));
	            item.setItemId(Integer.toString((int)row.getCell(1).getNumericCellValue()));
	            item.setTitle(row.getCell(2).getStringCellValue());
	            item.setActualPrice((float) row.getCell(3).getNumericCellValue());
	            item.setDiscountPrice((float) row.getCell(4).getNumericCellValue());
	            item.setDiscountedPercentage((int) row.getCell(5).getNumericCellValue());
	            item.setRatings(Integer.toString((int)row.getCell(6).getNumericCellValue()));
	            item.setNumberOfRating(Integer.toString((int)row.getCell(7).getNumericCellValue()));
	            item.setDescription(row.getCell(8).getStringCellValue());
	            item.setImageUrls(row.getCell(8).getStringCellValue());

	            for (CategoryList category : categoryList) {
	            	logger.trace("Repository:ProductDetailsRepo: Iterating Category list");
	                if (category.getCategoryId().equalsIgnoreCase(item.getCategoryId())) {
	                    List<ItemList> items = new ArrayList<>();
	                    if (category.getItemList() != null) {
	                        items = category.getItemList();
	                    }
	                    items.add(item);
	                    category.setItemList(items);
	                }
	            }
	        }
	        	
	        Session session = getSession();
            for (CategoryList category : categoryList) {
            	logger.info("Repository:ProductDetailsRepo: Saving Category list");
                session.saveOrUpdate(category);
            }
	        logger.info("Repository:ProductDetailRepo: Category and Item list saved in db");
		}catch(Exception exception) {
			logger.error("Repository:ProductDetailRepo: Exception");
			exception.printStackTrace();
		}
		
	}
	
}
