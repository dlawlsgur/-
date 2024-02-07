package com.ssadak.biz.chickenBreast;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Connection.Request;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssadak.biz.chickenInfo.ChickenInfoVO;
import com.ssadak.biz.mainservice.MainService;

import java.io.FileOutputStream;
import java.util.List;
import java.util.ArrayList;
@Controller
public class ChickenBreastController {

	
	@Autowired
	private MainService mainService;
	
    @RequestMapping("service.do")
    public String first(Model model) {
        // 크롬드라이버 매니저 연동
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        
        
        String url100 = "https://search.shopping.naver.com/search/all?adQuery=%EB%8B%AD%EA%B0%80%EC%8A%B4%EC%82%B4%20100g&frm=NVSHATC&origQuery=%EB%8B%AD%EA%B0%80%EC%8A%B4%EC%82%B4%20100g&pagingIndex=1&pagingSize=40&productSet=total&query=%EB%8B%AD%EA%B0%80%EC%8A%B4%EC%82%B4%20100g&sort=price_asc&timestamp=&viewType=list";
        String url150 = "https://search.shopping.naver.com/search/all?adQuery=%EB%8B%AD%EA%B0%80%EC%8A%B4%EC%82%B4%20150g&frm=NVSHATC&origQuery=%EB%8B%AD%EA%B0%80%EC%8A%B4%EC%82%B4%20150g&pagingIndex=1&pagingSize=40&productSet=total&query=%EB%8B%AD%EA%B0%80%EC%8A%B4%EC%82%B4%20150g&sort=price_asc&timestamp=&viewType=list";
        String urlIce = "https://search.shopping.naver.com/search/all?query=%EB%83%89%EB%8F%99%20%EB%8B%AD%EA%B0%80%EC%8A%B4%EC%82%B4&cat_id=&frm=NVSHATC";
        String[] urlList = {url100,url150,urlIce}; 
        String[] filter100 = {"냉동","소시","소세","바","생","볶음","150","200"};
        String[] filter150 = {"냉동","소시","소세","바","생","볶음","100","200"};
        String[] filterIce = {"종","식단","바","소시","소세","100","150"};
        
        
        
        ArrayList<String[]> filterList = new ArrayList<String[]>();
        filterList.add(filter100);
        filterList.add(filter150);
        filterList.add(filterIce);
      
        for(int j=0;j<urlList.length;j++) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get(urlList[j]);

        

        // 맨 아래까지 스크롤 내리기
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

       

        Document doc = Jsoup.parse(driver.getPageSource());
        Elements productElements = doc.select("div.product_item__MDtDF");

      

        
        int i=0;
        String[] filter = filterList.get(j);
        for (Element productElement : productElements) {
            int num = 0;
        	if(i==5) break;
        	String rink;
            String price;
           
            
            	for(String fill : filter) {
            		if (productElement.select("div.product_title__Mmw2K").text().contains(fill)) 
            			num=1;
            	}
            		
            	if(num==0) {
            	ChickenInfoVO info = new ChickenInfoVO();
                price = productElement.select("span.price_num__S2p_v em").text() + "원";
                rink = productElement.select("a.product_link__TrAac").attr("href");
                info.setCount(String.valueOf(i));
                info.setGroup(String.valueOf(j));
                info.setMenu(productElement.select("div.product_title__Mmw2K").text());
                info.setPrice(price);
                info.setRef(rink);
                
                mainService.insertBest(info); 
                i++;
                
            	}
            
        }
        driver.quit();
        }

        // main.jsp로 이동
        return "mamager.jsp";
    }
    @RequestMapping("ex.do")
    public String exportToExcel() throws Exception {
        
    	List<ChickenInfoVO> list =  mainService.getList();
    	
    	Workbook workbook = new XSSFWorkbook();
        
        
        Sheet sheet = workbook.createSheet("Crawled Data");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Group");
        headerRow.createCell(1).setCellValue("Menu");
        headerRow.createCell(2).setCellValue("Price");
        headerRow.createCell(3).setCellValue("Reference");

        // Populate data rows
        for (int i = 0; i < list.size(); i++) {
            ChickenInfoVO info = list.get(i);
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(info.getGroup());
            row.createCell(1).setCellValue(info.getMenu());
            row.createCell(2).setCellValue(info.getPrice());
            row.createCell(3).setCellValue(info.getRef());
        }

        // Write the workbook to the file
        try (FileOutputStream outputStream = new FileOutputStream("C:/best/best.xlsx")) {
            workbook.write(outputStream);
        }

        workbook.close();
        return "mamager.jsp";
    }
    @RequestMapping("main.do")
    public String main(Model model) {
    	
    			
    	List<ChickenInfoVO> list =  mainService.getList();
    	ArrayList<ChickenInfoVO> chickenList0 = new ArrayList<>();
    	ArrayList<ChickenInfoVO> chickenList1 = new ArrayList<>();
    	ArrayList<ChickenInfoVO> chickenList2 = new ArrayList<>();
    	
    	ChickenInfoVO vo = new ChickenInfoVO();
    	for(int i=0;i<list.size();i++) {
    		
    		vo=list.get(i);
    		if(vo.getGroup().equals("0")) {
    			chickenList0.add(vo);
    		}else if(vo.getGroup().equals("1")) {
    			chickenList1.add(vo);
    		}else if(vo.getGroup().equals("2")) {
    			chickenList2.add(vo);
    		}
    	}
    	
    	model.addAttribute("chickenList0",chickenList0);
    	model.addAttribute("chickenList1",chickenList1);
    	model.addAttribute("chickenList2",chickenList2);
    	
    	
    	return "main2.jsp";
    }
}
