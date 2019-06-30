package com.opc.locators;
/**
 * @author arghya
 * Version:
 * Date of Modification: 
 * 
 
 */
import org.openqa.selenium.By;



public class CloudHomePage {
	
	/*
	 * This locators are commonly used for most of the scripts
	 * 
	 */
	
	public static final By SIGNIN_BUTTON = By.xpath(".//*[@class='signInLink']/a/img");
	public static final By HOME_LINK = By.xpath("//li[@class='current']");
	public static final By Home_Product_Services = By.xpath("html/body/header/div/nav/section[1]/ul/li[2]/a");
	public static final By Homeuct_Services_Engage_Customers = By.xpath("//a[@href='/engage_customers']");
	public static final By Home_Resources = By.xpath("//li/a[@menu_id='resources_menu']"); // Updated at 17/03
	public static final By Home_sign_in= By.xpath("//a[@href='/sign_in']");
	
	/* Below locators are getting used for C9_LandingPage_01_HeaderFooter_Test
	 * 
	 */
		
	public static final By Home_About_Oracle= By.xpath("//a[text()='About Oracle']");
	public static final By Home_Contact_Us= By.xpath("//li/a[contains(text(),'Contact Us')]");
	public static final By Home_Legal_Notices= By.xpath("//a[text() ='Legal Notices']");
	public static final By Home_Terms_of_Use= By.xpath("//a[text()='Terms of Use']");
	public static final By Home_Your_Privacy_Rights= By.xpath("//a[text()='Your Privacy Rights']");
	public static final By Home_Contact_us_txt= By.xpath(".//*[@id='breadCrumb']/div[2]/div/span/a");
	public static final By Home_Legal_notice_txt= By.xpath("//div[@id='u01']/ul/li[1]/a/h3");
	public static final By Home_Terms_of_use_txt= By.xpath(".//*[@id='pfile-regs']/a");
	public static final By Home_privacy_txt= By.xpath("//div[@class='ct01 ct01v0']/ul/li[1]/a/span");
	

	/* Below locators are getting used for C9_LandingPage_03_ChatNow_ContactUs_Test
	 * 
	 */
	
	public static final By Home_Chat_Now= By.xpath("//div[@class='chat-tab']/a");
	public static final By Home_Chat_close= By.xpath("html/body/div[1]");
	public static final By Home_Contact_Us1= By.xpath("//div[@class='contact-tab']/a/img]");
	//public static final By Home_About_Oracle1= By.xpath("//div[@class='c29 c29v0']/h2");
	public static final By Home_About_Oracle1= By.xpath("//div[@class='u03w1']/ul/li");
	public static final By Home_Chat_Now_text= By.xpath("//div[@class='fd_heading_vis fd_heading_hpos']");
	public static final By Home_Contact_us_text= By.xpath("//a[text() = 'Contact Us']");
	
	
	/* Below locators are getting used for  C9_LandingPage_06_Engage_Customers_Test
	 * 
	 */
	
	public static final By Home_Leverage_Platform = By.xpath("//span[text()='Leverage Platform']");
	public static final By Home_Customer_Exp = By.xpath("//a/span[text()='Customer Experience']");
	//public static final By Home_Customer_Exp1 = By.xpath("//div[text()='Engage Customers']");
//	public static final By Home_Engage_Customers1 = By.xpath("html/body/div[1]/div/div[2]/h1"); // Need help to work with xpath
	public static final By Home_Engage_Customers1 =By.xpath("//h1[@class='blueBannerTitleWithSubtitle']");
	public static final By Home_Engage_Customer_overview = By.xpath("//a[contains(text(),'Overview')]");
	public static final By Home_Engage_Customer_overview_titel = By.xpath("//div[text()='Oracle Customer Experience Cloud']");
	public static final By Home_Engage_Customer_why_oracle = By.xpath("//a[contains(text(),'Why Oracle?')]");
	public static final By Home_Engage_Customer_why_oracle_title = By.xpath("//div[@class='whyOracleListingLayout']/h3[contains(text(),'Oracle Customer')]");// changed 17/3
	public static final By Home_Engage_Customer_Customer = By.xpath(".//*[@class='container']/ul/li[3]");
	public static final By Home_Engage_Customer_title = By.xpath("//div[text()='Oracle Cloud Customer Success']");
	public static final By Home_Engage_Customer_Marketing = By.xpath("//li/a[@href='/marketing']");
	public static final By Home_Engage_Customer_Marketing_title= By.xpath("//div[text()='Create Ideal Customers']"); // changed at 17/3
	public static final By Home_Engage_Customer_Marketing_Learn_more= By.xpath(".//*[@class='container']/ul/li[2]");
	public static final By Home_Engage_Customer_Marketing_Learn_more_title= By.xpath("//div[text()='Additional Resources']"); //changed at 17/3
	
	/* Below locators are getting used for  C9_LandingPage_08_Engage_Sales_Test
	 * 
	 */
		
	public static final By Home_Engage_Sales1= By.xpath("//a[@href='/sales']");
	public static final By Home_Engage_Sales1_Overview_title= By.xpath("//div[text()='Sell Smarter']");
	public static final By Home_Engage_Sales1_Overview_pricing= By.xpath("//a[@href='/sales?tabID=1383678927294']");
	public static final By Home_Engage_Sales1_Overview_pricing_Enterprise_end= By.xpath("//span[text()='Enterprise Edition']");
	public static final By Home_Engage_Sales1_Overview_pricing_Learn_More= By.xpath("//li/a[contains(text(),'Learn More')]");
	public static final By Home_Engage_Sales1_Overview_pricing_Learn_More_datasheet= By.xpath("//a[@href='/sales?lmResID=1383678930460&tabID=1383678931929']");
	
	/* Below locators are getting used for  C9_LandingPage_08_Service_Test
	 * 
	 */
	
	public static final By Home_Engage_Service= By.xpath("//a[@href='/service']");
	public static final By Home_Engage_Service_overview_title= By.xpath("//div[text() = 'Delight Your Customers']");
	public static final By Home_Engage_Service_overview_pricing= By.xpath("//div[@class='container']/ul/li[2]");
	public static final By Home_Engage_Service_overview_pricing_Enter_eed= By.xpath("//div/span[text()='Standard Dynamic Agent Desktop']");
	public static final By Home_Engage_Service_overview_learn_more= By.xpath("//div[@class='container']/ul/li[3]");
	public static final By Home_Engage_Service_overview_learn_more_datasheet= By.xpath("//a[text()='Data Sheets']");
	public static final By Home_Engage_Service_overview_learn_more_datasheet1= By.xpath("//a[text()='Data Sheets']");
	public static final By Home_Engage_Service_overview_Customers= By.xpath("//div[@class='container']/ul/li[4]");
	public static final By Home_Engage_Service_overview_Customers_title= By.xpath("//div[text()='Service Cloud Customer Successes']");
	
	
	/* Below locators are getting used for  C9_LandingPage_09_Empower_People_Test
	 * 
	 */
	
	public static final By Home_Empower_People= By.xpath("//a[@href='/empower_people']");
	public static final By Home_Empower_People_title= By.xpath("//div[text()='Realize the Power of Your Employees']");
	public static final By Home_Empower_People_why_oracle= By.xpath("//a[@href='/empower_people?tabID=1383678918932']");
	public static final By Home_Empower_People_why_oracle_title= By.xpath("//h3[contains(text(),'Find and Retain the Best Talent')]");
	public static final By Home_Empower_People_why_oracle_title1= By.xpath("//h3[contains(text(),'Experiences Employees Expect')]");
	public static final By Home_Empower_People_customers= By.xpath("//a[@href='/empower_people?tabID=1383678918947']");
	public static final By Home_Empower_People_customers_title= By.xpath("//div[text()='Oracle Cloud Customer Successes']");
	
	/* Below locators are getting used for  C9_LandingPage_10_Global_Human_Resources_Test
	 * 
	 */
	
	
	public static final By Home_Empower_People_Global_Resources= By.xpath("//a[@href='/global_human_resources']");
	public static final By Home_Empower_People_Global_Resources_overview_title= By.xpath("//div[text()='Gain Operational Excellence and Increase Global Agility']");
	public static final By Home_Empower_People_pricing= By.xpath("//a[@href='/global_human_resources?tabID=1383678919561']");
	public static final By Home_Empower_People_pricing_title= By.xpath("//span[text()='Global Human Resources']");
	public static final By Home_Empower_People_learn_more= By.xpath("//a[@href='/global_human_resources?tabID=1383678919611']");
	public static final By Home_Empower_People_learn_more_data_sheet= By.xpath("//a[@href='/global_human_resources?lmResID=1383678919612&tabID=1383678919611']");
	public static final By Home_Empower_cusrtomers= By.xpath("//a[@href='/global_human_resources?tabID=1383678919685']");
	public static final By Home_Empower_cusrtomers_title= By.xpath("//div[@class='overviewLayout']/div"); 
	public static final By Home_Empower_talent_management= By.xpath("//li/a[contains(text(),'Talent Management')]");
	public static final By Home_Empower_talent_management_overview_title =  By.xpath("//div[text()='Find and Retain the Best Talent']");// changed at 17/3
	public static final By Home_Empower_talent_management_overview_title1 =  By.xpath("//div[text()='Develop and engage your workforce']");// changed at 17/3
	public static final By Home_Empower_talent_management_pricing= By.xpath("//a[@href='/talent_management?tabID=1383678918842']");
	public static final By Home_Empower_talent_management_pricing_title= By.xpath("//span[text()='Learning & Development']");
	public static final By Home_Empower_talent_management_learn_more= By.xpath("//a[@href='/talent_management?tabID=1383678918557']");
	public static final By Home_Empower_talent_management_learn_more_title= By.xpath("//a[@href='/talent_management?lmResID=1383678918558&tabID=1383678918557']");
	public static final By Home_Empower_talent_management_Customers= By.xpath("//a[@href='/talent_management?tabID=1383678918597']");
	public static final By Home_Empower_talent_management_Customers_title= By.xpath("//div[text()='HCM Talent Management Customer Successes']");
	
	 
	/* Below locators are getting used for C9_LandingPage_02_Verifying_Main_Links_Test   14/06/2016
	 * 
	 */
	
	public static final By Home_Verifying_Main_Links_applications= By.xpath((".//*[@id='homepage-category-group-tabs']/div/dl/dd[1]/a/h4"));
	public static final By Home_Verifying_Main_Links_platform= By.xpath((".//*[@id='homepage-category-group-tabs']/div/dl/dd[2]/a/h4"));
	public static final By Home_Verifying_Main_Links_marketplace= By.xpath((".//*[@id='homepage-category-group-tabs']/div/dl/dd[3]/a/h4"));
	
	public static final By Home_Verifying_Main_Links_applications1= By.xpath((".//*[@id='offersMenu']/div/div/div[1]/div/li/div/span"));
	public static final By Home_Verifying_Main_Links_customer_experience= By.xpath((".//*[@id='offersMenu']/div/div/div[1]/div/div[1]/li/a/span"));
	public static final By Home_Verifying_Main_Links_customer_experience_engage= By.xpath(("//h3[text()='Engage Customers']"));
	
	public static final By Home_Verifying_Main_Links_Supply_Chain_Management= By.xpath((".//*[@id='offersMenu']/div/div/div[1]/div/div[4]/li/a/span"));
	public static final By Home_Verifying_Main_Links_Supply_Chain_Management_overview= By.xpath(("//h5[text()='Value Chain Execution: Transportation & Global Trade Management']"));
	
	public static final By Home_Verifying_Main_Links_social= By.xpath((".//*[@id='offersMenu']/div/div/div[1]/div/div[7]/li/a/span"));
	public static final By Home_Verifying_Main_Links_social_overview= By.xpath((".//*[@id='category-overview-service-section']/div/div/div/div/div[1]/div/div/div[2]/div[1]/div/h5"));
	
	public static final By Home_Verifying_Main_Links_Industry_Solutions= By.xpath((".//*[@id='offersMenu']/div/div/div[1]/div/div[10]/li/a/span"));
	public static final By Home_Verifying_Main_Links_Industry_Solutions_engage= By.xpath(("//h5[text()='CX for Communications']"));
	
	
	public static final By Home_Verifying_Main_Links_Industry_Human_Capital_Management= By.xpath((".//*[@id='offersMenu']/div/div/div[1]/div/div[2]/li/a/span"));
	public static final By Home_Verifying_Main_Links_Industry_Human_Capital_Management_engage= By.xpath(("//h5[text()='Global Human Resources Cloud']"));
	
	
	
	public static final By Home_Verifying_Main_Links_Enterprise_Performance_Mgmt= By.xpath((".//*[@id='offersMenu']/div/div/div[1]/div/div[5]/li/a/span"));
	public static final By Home_Verifying_Main_Links_Enterprise_Performance_Mgmt_engage= By.xpath(("//h5[text()='Planning and Budgeting']"));
	
	public static final By Home_Verifying_Main_Links_Data= By.xpath((".//*[@id='offersMenu']/div/div/div[1]/div/div[8]/li/a/span"));
	public static final By Home_Verifying_Main_Links_Data_engage= By.xpath(("//h5[text()='DaaS for Marketing']"));
	
	
	public static final By Home_Verifying_Main_Links_Enterprise_Resource_Planning= By.xpath((".//*[@id='offersMenu']/div/div/div[1]/div/div[3]/li/a/span"));
	public static final By Home_Verifying_Main_Links_Enterprise_Resource_Planning_engage= By.xpath(("//h5[text()='Financials']"));
	
	
	public static final By Home_Verifying_Main_Links_Analytics= By.xpath((".//*[@id='offersMenu']/div/div/div[1]/div/div[6]/li/a/span"));
	public static final By Home_Verifying_Main_Links_Analytics_engage= By.xpath(("//h5[text()='HCM Analytics']"));
	
	
	public static final By Home_Verifying_Main_Links_Industry_Clouds= By.xpath((".//*[@id='offersMenu']/div/div/div[1]/div/div[9]/li/a/span"));
	public static final By Home_Verifying_Main_Links_Industry_Clouds_engage= By.xpath(("//h5[text()='Financial Services Cloud']"));
	
	// PLATFORM ( PaaS / IaaS )
	
	//public static final By Home_Verifying_Main_Links_platform1= By.xpath((".//*[@id='offersMenu']/div/div/div[2]/div[1]/li/div/span"));
	
	public static final By Home_Verifying_Main_Links_platform2= By.xpath((".//*[@id='offersMenu']/div/div/div[2]/div[1]/div[1]/li/a/span"));
	public static final By Home_Verifying_Main_Links_platform2_database= By.xpath(("//h5[text()='Database']"));
	
	public static final By Home_Verifying_Main_Links_platform2_database1= By.xpath((".//*[@id='offersMenu']/div/div/div[2]/div[1]/div[1]/li/ul/li[2]/a"));
	public static final By Home_Verifying_Main_Links_platform2_database2= By.xpath(("//h2[text()='Your Oracle Database in the Cloud.']"));
	
	public static final By Home_Verifying_Main_Links_platform2_java= By.xpath((".//*[@id='offersMenu']/div/div/div[2]/div[1]/div[1]/li/ul/li[3]/a"));
	public static final By Home_Verifying_Main_Links_platform2_java1= By.xpath(("//h2[text()='Oracle Java Cloud Service.']"));
	
	public static final By Home_Verifying_Main_Links_platform2_messaging= By.xpath((".//*[@id='offersMenu']/div/div/div[2]/div[1]/div[1]/li/ul/li[4]/a"));
	public static final By Home_Verifying_Main_Links_platform2_messaging1= By.xpath(("//h2[text()='Dynamic Messaging for Business Workflow Agility.']"));
	
	public static final By Home_Verifying_Main_Links_Infrastructure01= By.xpath((".//*[@id='offersMenu']/div/div/div[2]/div[1]/div[2]/li/a/span"));
	public static final By Home_Verifying_Main_Links_Infrastructure02= By.xpath(("//h5[text()='Compute']"));
	
	
	public static final By Home_Verifying_Main_Links_Compute01= By.xpath((".//*[@id='offersMenu']/div/div/div[2]/div[1]/div[2]/li/ul/li[2]/a"));
	public static final By Home_Verifying_Main_Links_Compute02= By.xpath(("//h2[text()='Elastic Compute Capacity to Address Growing Business Needs.']"));
	
	
	public static final By Home_Verifying_Main_Links_Storage01= By.xpath((".//*[@id='offersMenu']/div/div/div[2]/div[1]/div[2]/li/ul/li[3]/a"));
	public static final By Home_Verifying_Main_Links_Storage02= By.xpath(("//h2[text()='Storage for All of Your Enterprise Needs.']"));
	
	public static final By Home_Verifying_Main_Links_CLOUD_MARKETPLACE01= By.xpath((".//*[@id='offersMenu']/div/div/div[2]/div[2]/li/div/a/span"));
	public static final By Home_Verifying_Main_Links_CLOUD_MARKETPLACE02= By.xpath(("//span[text()='Cloud Marketplace']"));
	
	
	
	
	// new 
	
	
	/* Below locators are getting used for  C9_LandingPage_11_Leverage_Value_Chain_Test
	 * 
	 */
	
	public static final By Home_Leverage_Value_Chain= By.xpath("//a[@href='/value_chain_execution']");
	public static final By Home_Leverage_Value_Chain_overview= By.xpath("//div[text() = 'Innovate, Execute and Scale Rapidly']");
	public static final By Home_Leverage_Value_Chain_why_oracle= By.xpath("//a[contains(text(),'Why Oracle?')]");
	public static final By Home_Leverage_Value_Chain_why_oracle_title= By.xpath("//div[@class='whyOracleListingLayout']/h3[contains(text(),'Oracle Supply')]"); // changed at 17/03
	public static final By Home_Leverage_Value_Chain_why_oracle_title_Customer= By.xpath("//div[text()='Value Chain Execution Customer Successes']");
	public static final By Home_Leverage_Value_Chain_why_oracle_title_pricing= By.xpath("//span[text()='Oracle Trans Operational Planning Cloud Service']");
	public static final By Home_Leverage_Value_Chain_01= By.xpath("//a[contains(text(),'Transportation and Global Trade')]");
	public static final By Home_Leverage_Value_Chain_title= By.xpath("//div[text() = 'Modern Transportation and Global Trade']");
	public static final By Home_Leverage_Value_Chain_learn_more= By.xpath("//a[contains(text(),'Learn More')]");
	public static final By Home_Leverage_Value_Chain_learn_more_title= By.xpath("//a[@href='/value_chain_execution?lmResID=1383678928129&tabID=1383678928128']");
	public static final By Home_Leverage_Value_Chain_customers= By.xpath("//li/a[contains(text(),'Customers')]");
	public static final By Home_Leverage_Value_Chain_customers_title= By.xpath("//div[text()='Value Chain Execution Customer Successes']");
	public static final By Home_Leverage_Value_Chain_Product_value_chain= By.xpath("//a[contains(text(),'Product Value Chain')]");
	public static final By Home_Leverage_Value_Chain_Product_value_chain_title= By.xpath("//div[text() = 'Product Value Chain Management']");
	public static final By Home_Leverage_Value_Chain_Product_value_chain_title1= By.xpath("//div[text() = 'Master and Commercialize Products']");
	public static final By Home_Leverage_Value_Chain_Product_value_chain_title2= By.xpath("//div[text() = 'Global Inventory and Cost Management in the Cloud']");
	public static final By Home_Leverage_Value_Chain_Product_value_chain_learn_more= By.xpath("//a[contains(text(),'Learn More')]");
	public static final By Home_Leverage_Value_Chain_Product_value_chain_learn_more_title= By.xpath("//a[@href='/product_value_chain?lmResID=1383678920374&tabID=1383678920373']");
	public static final By Home_Leverage_Value_Chain_Product_value_chain_Customers= By.xpath("//div[@class='container']/ul/li[4]");
	public static final By Home_Leverage_Value_Chain_Product_value_chain_Customers_title= By.xpath("//div[text()='Product Value Chain Customer Successes']");
	public static final By Home_Leverage_Value_Chain_Product_value_chain_Customers_title1= By.xpath("//div[text()='Value Chain Execution Customer Successes']");
	public static final By Home_Leverage_Value_Chain_Product_Value_Customers_Pricing=By.xpath("//a[@href='/product_value_chain?tabID=1386233423472']");
	public static final By Home_Leverage_Value_Chain_Product_Value_Customers_Pricing_text=By.xpath("//span[text()='Product Development Cloud Service']");
	public static final By Home_Leverage_Value_Chain_Product_Value_Customers_Pricing_text1=By.xpath("//span[text()='Inventory and Cost Management']");
	
	
	/* Below locators are getting used for  C9_LandingPage_12_Manage_Enterprise_Performance_Test
	 * 
	 */
	
	//public static final By Home_Manage_Enterprise_Performance= By.xpath("//span/a[text()='Manage Enterprise Performance']");
	public static final By Home_Manage_Enterprise_Performance= By.xpath("//span[text()='Enterprise Performance Mgmt']");
	public static final By Home_Manage_Enterprise_Performance_overview= By.xpath("//div[text() = 'Unlock Business Potential']");
	public static final By Home_Manage_Enterprise_Performance_why_oracle= By.xpath("//a[contains(text(),'Why Oracle?')]");
	public static final By Home_Manage_Enterprise_Performance_why_oracle_title= By.xpath("//a[contains(text(),'Why Oracle?')]");
	public static final By Home_Manage_Enterprise_Performance_customers= By.xpath("//li/a[contains(text(),'Customers')]");
	public static final By Home_Manage_Enterprise_Performance_customers_title= By.xpath("//div[contains(text(),'Enterprise Resource Planning Customers')]");
	public static final By Home_Manage_Enterprise_Performance_customers_title2= By.xpath("//div[contains(text(),'Oracle EPM Cloud Testimonials')]");
	public static final By Home_Manage_Enterprise_Performance_customers_title1= By.xpath("//span[text()='Planning and Budgeting']");
	public static final By Home_Manage_Enterprise_Performance_enterprise_planning= By.xpath("//a[contains(text(),'Enterprise Planning')]");
	public static final By Home_Manage_Enterprise_Performance_enterprise_planning_txt= By.xpath("//div[text() = 'World-class Planning and Budgeting with the Simplicity of the Cloud']");
	public static final By Home_Manage_Enterprise_Performance_enterprise_learn_more= By.xpath("//a[contains(text(),'Learn More')]");
	public static final By Home_Manage_Enterprise_Performance_enterprise_learn_more_txt= By.xpath("//a[@href='/enterprise_planning?lmResID=1383678926190&tabID=1383678926175']");
	public static final By Home_Manage_Enterprise_Performance_enterprise_financial_reporting= By.xpath("//a[contains(text(),'Financial Performance Reporting')]");
	public static final By Home_Manage_Enterprise_Performance_enterprise_financial_reporting_txt= By.xpath("//div[text()='Accelerate your Financial, Management and Narrative Reporting Processes']");
	public static final By Home_Manage_Enterprise_Performance_enterprise_financial_reporting_txt1= By.xpath("//div[text()='Streamline financial and management reporting process']");
	public static final By Home_Manage_Enterprise_Performance_enterprise_financial_reporting_learn_more= By.xpath("//a[contains(text(),'Learn More')]");
	public static final By Home_Manage_Enterprise_Performance_enterprise_financial_reporting_learn_more_txt= By.xpath("//div[text() = 'FAQ']");
	
	
	/* Below locators are getting used for  C9_LandingPage_13_Get_Social_Test
	 * 
	 */
	
	public static final By Home_Manage_Get_Social= By.xpath("//span[text()='Social']");
	public static final By Home_Manage_Get_Social_overview= By.xpath("//div[contains(text(),'Socially Enable Your Enterprise')]");
	public static final By Home_Manage_Get_Social_why_oracle= By.xpath("//a[contains(text(),'	Why Oracle?')]");
	public static final By Home_Manage_Get_Social_why_oracle_title= By.xpath("//div[@class='whyOracleListingLayout']/h3[contains(text(),'Why Oracle')]"); //Updated at 17/03
	public static final By Home_Manage_Get_Social_social_network= By.xpath("//a[contains(text(),'Social Network')]");
	public static final By Home_Manage_Get_Social_social_network_overview= By.xpath("//div[text() = 'Secure Collaboration for Everyone You Work With']");
	public static final By Home_Manage_Get_Social_social_network_learn_more= By.xpath("//a[contains(text(),'Learn More')]");
	public static final By Home_Manage_Get_Social_social_network_learn_more_txt= By.xpath("//a[@href='/social_network?lmResID=1383678915622&tabID=1383678915621']");
	public static final By Home_Manage_Get_Social_social_marketing= By.xpath("//a[contains(text(),'Social Marketing')]");
	public static final By Home_Manage_Get_Social_social_marketing_txt= By.xpath("//div[text()='Build Brands on Social Technology']");
	public static final By Home_Manage_Get_Social_social_marketing_txt1= By.xpath("//div[text()='Build brands on Social Technology']");
	public static final By Home_Manage_Get_Social_social_marketing_learn_more= By.xpath("//a[contains(text(),'Learn More')]");
	public static final By Home_Manage_Get_Social_social_marketing_learn_more_txt= By.xpath("//div[text()='FAQ']");
	public static final By Home_Manage_Get_Social_Engagement_and_Monitoring= By.xpath("//a[contains(text(),'Social Engagement and Monitoring')]");
	public static final By Home_Manage_Get_Social_Engagement_and_Monitoring_overview= By.xpath("//div[text()='Engage on What is Important to Your Consumers']");
	public static final By Home_Manage_Get_Social_Engagement_and_Monitoring_overview1= By.xpath("//div[text()='Engage on what is important to your consumers']");
	public static final By Home_Manage_Get_Social_data_and_insight= By.xpath("//a[contains(text(),'Social Data and Insight')]");
	public static final By Home_Manage_Get_Social_data_and_insight_txt= By.xpath("//div[text()='Get Smart About Your Customers and Contacts']");
	public static final By Home_Manage_Get_Social_data_and_insight_txt1= By.xpath("//div[text()='Get smart about your customers and contacts']");
	
	/* Below locators are getting used for  C9_LandingPage_14_Build_Apps_Test
	 * 
	 */
	
	public static final By Home_Manage_build_apps_database= By.xpath(".//*[@class='dropdown row']/li[2]/a[@href='/database']");
	public static final By Home_Manage_build_apps_database_overview= By.xpath("//div/h4[text()='Fast.']");
	public static final By Home_Manage_build_apps_database_overview1= By.xpath("//div[text()='The Oracle Database you love, now in the cloud']");
	public static final By Home_Manage_build_apps_database_pricing= By.xpath("//a[contains(text(),'	Pricing')]");
	public static final By Home_Manage_build_apps_database_pricing_title= By.xpath("//div[contains(text(),'Database Cloud Pricing')]");
	public static final By Home_Manage_build_apps_database_learn_more= By.xpath("//a[contains(text(),'Learn More')]");
	public static final By Home_Manage_build_apps_database_learn_more_title= By.xpath("//a[@href='/database?lmResID=1383678929049&tabID=1383678929020']");
	public static final By Home_Manage_build_apps_database_Customer_title= By.xpath("//div[text()='Oracle Database Cloud Service Customer Successes']");
	public static final By Home_Manage_build_apps_java= By.xpath(".//*[@class='dropdown row']/li[3]/a[@href='/java']");
	public static final By Home_Manage_build_apps_java_overview= By.xpath("//div/h2[text() = 'Oracle Java Cloud Service.']");
	public static final By Home_Manage_build_apps_java_overview1= By.xpath("//div[text() = 'Enjoy all the productivity of Java, without the IT']");
	public static final By Home_Manage_build_apps_java_pricing= By.xpath("//li/a[contains(text(),'Pricing')]");
	public static final By Home_Manage_build_apps_java_pricing_title= By.xpath("//div/h5[text() = 'Java Cloud Service']");
	public static final By Home_Manage_build_apps_java_learn_more= By.xpath("//a[contains(text(),'Learn More')]");
	public static final By Home_Manage_build_apps_java_learn_more_title= By.xpath("//a[@href='/java?lmResID=1383678929740&tabID=1383678929739']");
	public static final By Home_Manage_build_apps_java_customer= By.xpath(".//*[@class='offerNavBarLayout']/div/div/ul/li[4]");
	public static final By Home_Manage_build_apps_java_customer_title= By.xpath("//div[text() = 'Java Customer Successes']");
	public static final By Home_Manage_build_apps_developer= By.xpath("//li/a[contains(text(),'Developer')]");
	public static final By Home_Manage_build_apps_developer_overview= By.xpath("//div[text() ='A Platform as a Service Development Environment for the Enterprise']");
	public static final By Home_Manage_build_apps_developer_overview1= By.xpath("//div[text() ='A platform as a service development environment for the enterprise']");
	public static final By Home_Manage_build_apps_developer_learn_more= By.xpath("//a[contains(text(),'Learn More')]");
	public static final By Home_Manage_build_apps_developer_learn_more_title= By.xpath("//div[text()='FAQ']");
	public static final By Home_Manage_build_apps_documents= By.xpath("//li/a[contains(text(),'Documents')]");
	public static final By Home_Manage_build_apps_documents_title= By.xpath("//div[contains(text(),'Enterprise File Sync and Share in the Oracle Cloud')]");
	public static final By Home_Manage_build_apps_documents_title1= By.xpath("//div[contains(text(),'File sync and share in the Oracle Cloud')]");
	public static final By Home_Manage_build_apps_documents_pricing_title= By.xpath("//div[contains(text(),'Oracle Documents Cloud Service')]");
	public static final By Home_Manage_build_apps_documents_learn_more= By.xpath("//a[@href='/documents?tabID=1383678914215']");
	public static final By Home_Manage_build_apps_documents_learn_more_title= By.xpath("//div[text()='FAQ']");
	public static final By Home_Manage_build_apps_business_intelligence= By.xpath("//a[@href='/business_intelligence']");
	public static final By Home_Manage_build_apps_business_intelligence_overview= By.xpath("//div[contains(text(),'Agile Business Intelligence in the Cloud for Everyone')]");
	public static final By Home_Manage_build_apps_business_intelligence_overview1= By.xpath("//div[contains(text(),'Enterprise-class Business Intelligence in the cloud for everyone')]");
	public static final By Home_Manage_build_apps_Mobile= By.xpath("//li/a[@href='/mobile']");
	public static final By Home_Manage_build_apps_Mobile_title= By.xpath("//div[text()='Simplify Enterprise Mobile Connectivity']");
	public static final By Home_Manage_build_apps_Database_Backup= By.xpath("//a[@href='/database_backup']");
	public static final By Home_Manage_build_apps_Database_Backup_overview_title= By.xpath("//div[text()='Storage for all Your Oracle Database Backup Needs']");
	public static final By Home_Manage_build_apps_Database_Backup_pricing_title= By.xpath("//div[contains(text(),'Database Backup Cloud Pricing')]");
	
	public static final By Home_Manage_build_apps_overview= By.xpath(".//*[@id='category-tabs']/div/div/dl/dd[1]/div/a[2]/span");
	public static final By Home_Manage_Overview1= By.xpath(".//*[@id='category-why-oracle-details']/div/div[1]/h3");
	public static final By Home_Manage_Overview2= By.xpath("//div/h3[text()='Oracle Cloud Platform as a Service (PaaS) Customer Successes']");
	
	
	public static final By Home_Manage_messging= By.xpath(".//*[@class='dropdown row']/li[4]/a[@href='/messaging']");
	public static final By Home_Manage_messging_overview_txt= By.xpath("//div/h2[text()='Dynamic Messaging for Business Workflow Agility.']");
	public static final By Home_Manage_messging_pricing= By.xpath(".//*[@id='service-tabs-section']/div/dl/dd[2]/div/a[2]/span");
	public static final By Home_Manage_messging_pricing_txt= By.xpath("//li/h5[text()='Oracle Messaging Cloud Service']");
	public static final By Home_Manage_messging_learn_more= By.xpath(".//*[@id='service-tabs-section']/div/dl/dd[3]/div/a[2]/span");
	
	

	
	 
	
	/* Below locators are getting used for C9_LandingPage_15_Leverage_Infrastructure_Test
	 * 
	 */
	public static final By Home_Manage_Leverage_Infrastructure_Home= By.xpath(".//*[@id='offersMenu']/div/div/div[2]/div[1]/div[2]/li/a/span");
	public static final By Home_Manage_Leverage_Infrastructure_overview= By.xpath("//span[contains(text(),'Overview')]");
	public static final By Home_Manage_Leverage_Infrastructure_whyoracle= By.xpath("//span[contains(text(),'Why Oracle?')]");
	public static final By Home_Manage_Leverage_Infrastructure_whyoraclecompute= By.xpath("//h3[contains(text(),'Why Oracle Cloud?')]");
	public static final By Home_Manage_Leverage_Infrastructure_Compute= By.xpath(".//*[@class='dropdown row']/li[2]/a[@href='/compute']");
	public static final By Home_Manage_Leverage_Infrastructure_Compute_overview= By.xpath("//div/h2[contains(text(),'Elastic Compute Capacity to Address Growing Business Needs.')]");
	public static final By Home_Manage_Leverage_Infrastructure_Compute_overview1= By.xpath("//div[text()='Elastic compute capacity to address growing business needs']");
	public static final By Home_Manage_Leverage_Infrastructure_Compute_learn_more= By.xpath("//span[contains(text(),'Learn More')]");
	public static final By Home_Manage_Leverage_Infrastructure_Compute_learn_more_txt= By.xpath("//a[text()='Oracle Compute Cloud Service']");
	public static final By Home_Manage_Leverage_Infrastructure_Compute_pricing= By.xpath("//div/h3[contains(text(),'Compute Cloud Pricing')]");
	public static final By Home_Manage_Leverage_Infrastructure_Object_Storage= By.xpath(".//*[@class='dropdown row']/li[3]/a[@href='/storage']");
	public static final By Home_Manage_Leverage_Infrastructure_Object_Storage_overview= By.xpath(".//*[@id='service-overview-section']/div/div[2]/div/h2");
	public static final By Home_Manage_Leverage_Infrastructure_Object_Storage_overview1= By.xpath("//div[text()='Storage for all of your enterprise needs']");
	public static final By Home_Manage_Leverage_Infrastructure_Object_Storage_learn_more= By.xpath("//span[contains(text(),'Learn More')]");
	public static final By Home_Manage_Leverage_Infrastructure_Object_Storage_learn_more_txt= By.xpath(".//*[@id='resources-learnmore-content-section']/div/div/div[3]/div/div/h6/a");
	public static final By Home_Manage_Leverage_Infrastructure_Object_Storage_Pricing_text= By.xpath("//div/span[text()='Storage Cloud Pricing']");
	public static final By Home_Manage_Leverage_Infrastructure_messaging= By.xpath("//li/a[contains(text(),'Messaging')]");
	public static final By Home_Manage_Leverage_Infrastructure_messaging_txt= By.xpath("//div[text() = 'Dynamic Messaging for Business Workflow Agility']");
	public static final By Home_Manage_Leverage_Infrastructure_messaging_learn_more= By.xpath("//a[contains(text(),'Learn More')]");
	public static final By Home_Manage_Leverage_Infrastructure_messaging_learn_more_txt= By.xpath("//a[@href='/messaging?lmResID=1383678927534&tabID=1383678932968']");
	public static final By Home_Manage_Leverage_Infrastructure_messaging_pricing= By.xpath("//div/span[text()='Oracle Messaging Cloud Service']");
	public static final By Home_Manage_Leverage_Infrastructure_Compute_pricing1= By.xpath(".//*[@id='service-tabs-section']/div/dl/dd[2]/div/a[2]/span");
	public static final By Home_Manage_Leverage_Infrastructure_Object_pricing= By.xpath(".//*[@id='service-tabs-section']/div/dl/dd[2]/div/a[2]/span");
	public static final By Home_Manage_Leverage_Infrastructure_storage_pricing1= By.xpath("//span[contains(text(),'Pricing')]");
	public static final By Home_Manage_Leverage_Infrastructure_Storage_pricing01= By.xpath("//h3[contains(text(),'Storage Cloud Pricing')]");
	
	
	/* Below locators are getting used for Cloud Market Page
	 * 
	 */
	public static final By Home_Manage_Cloud_Market_place= By.xpath(".//*[@id='offersMenu']/div/div/div[2]/div[2]/li/div/a/span");
	public static final By Home_Manage_Cloud_Market_place_txt= By.xpath("//span[text()='Featured Apps']");
	
	
	
	/* Below locators are getting used for C9_LandingPage_05_All_Buttons_Test
	 * 
	 */
	
	public static final By Home_Manage_button_trial= By.xpath(".//*[@id='applications']/div[1]/div/div[2]/a/img");
	public static final By Home_Manage_details_button= By.xpath("//a[@href='/database']/span[contains(text(),'Details')]");
	public static final By Home_Manage_details_sign_in_sso= By.xpath(".//*[@id='pageone']/div[2]/div[1]/form/ul/li[4]/a");
	public static final By Home_Manage_TryIt_button= By.xpath("//a[@href='https://myaccount.c9qaga.us.oracle.com/mycloud/faces/trialsignup.jspx?serviceType=APEX')]");
	public static final By HOME_MANAGE_SIGN_IN= By.xpath("//li/a[@href = '/sign_in']");
	public static final By HOME_MANAGE_SIGN_IN_MY_SERVICES= By.xpath("//div/a/span[text() = 'Sign In to My Services']");
	public static final By HOME_MANAGE_SIGN_IN_MY_ACCOUNT= By.xpath("//div/a/span[text() = 'Sign In to My Account']");
	public static final By HOME_MANAGE_SIGN_IN_SELF_SERVICE = By.xpath("//div/a/span[contains(text(),'Sign In to Cloud Home')]");
	public static final By HOME_MANAGE_SIGN_IN_NOTIFICATION = By.xpath("//div/a/span[contains(text(),'Sign In to Notifications')]");
	
	/* Below locators are getting used for  C9_LandingPage_16_Resources_Discover_Test
	 * 
	 */
	
	//public static final By Home_Manage_Resources= By.xpath("//ul[@class='opcNav']/li[3]");
	public static final By Home_Manage_Resources=By.xpath("//ul/li[4]/a[contains(text(),'Resources')]");
	public static final By Home_Manage_Resources_blog= By.xpath(".//*[@id='resourcesMenu']/div/div/div[1]/li/ul/li[1]/a");
	public static final By Home_Manage_Resources_blog_txt= By.xpath(".//*[@id='artificial_intelligence_as_core_it']/h3/a");
	public static final By Home_Manage_Customers= By.xpath(".//*[@id='resourcesMenu']/div/div/div[1]/li/ul/li[2]/a");
	public static final By Home_Manage_Customers_txt= By.xpath(".//*[@id='resources-banner-section']/div/div/div/div/div[2]/h1");
	public static final By Home_Manage_Data_Sheet= By.xpath(".//*[@id='resourcesMenu']/div/div/div[1]/li/ul/li[3]/a");
	public static final By Home_Manage_Data_Sheet_title= By.xpath(".//*[@id='resources-banner-section']/div/div/div/div/div[2]/h1");
	public static final By HOME_RESOURCE_DEMOS_VIDEOS = By.xpath(".//*[@id='resourcesMenu']/div/div/div[1]/li/ul/li[4]/a");
	public static final By HOME_RESOURCE_DEMOS_VIDEOS_TITLE = By.xpath(".//*[@id='resources-banner-section']/div/div/div/div/div[2]/h1");
	public static final By HOME_RESOURCE_FAQ = By.xpath(".//*[@id='resourcesMenu']/div/div/div[1]/li/ul/li[7]/a");
	public static final By HOME_RESOURCE_FAQ_TITLE = By.xpath(".//*[@id='resources-content-section']/div/div/div[2]/aside/ul/li[1]/a");
	public static final By HOME_RESOURCE_DOCUMENTATION = By.xpath(".//*[@id='resourcesMenu']/div/div/div[1]/li/ul/li[5]/a");
	public static final By HOME_RESOURCE_DOCUMENTATION_TXT = By.xpath(".//*[@id='main']/h1");
	public static final By HOME_RESOURCE_EBOOK = By.xpath(".//*[@id='resourcesMenu']/div/div/div[1]/li/ul/li[6]/a");
	public static final By HOME_RESOURCE_EBOOK_TXT = By.xpath(".//*[@id='resources-banner-section']/div/div/div/div/div[2]/h1");
	public static final By HOME_RESOURCE_WHATSNEW = By.xpath(".//*[@id='resourcesMenu']/div/div/div[1]/li/ul/li[10]/a");
	public static final By HOME_RESOURCE_WHATSNEW_TXT = By.xpath(".//*[@id='resources-banner-section']/div/div/div/div/div[2]/h1");
	public static final By HOME_RESOURCE_FORUMS = By.xpath(".//*[@id='resourcesMenu']/div/div/div[1]/li/ul/li[8]/a");
	public static final By HOME_RESOURCE_FORUMS_TXT = By.xpath(".//*[@id='resources-banner-section']/div/div/div/div/div[2]/h1");
	
	public static final By HOME_RESOURCE_PRESS_RELEASE = By.xpath(".//*[@id='resourcesMenu']/div/div/div[1]/li/ul/li[9]/a");
	public static final By HOME_RESOURCE_PRESS_RELEASE_TXT = By.xpath(".//*[@id='pfile-regs']/a");
	
	public static final By HOME_RESOURCE_WHITE_PAPERS = By.xpath("//li/a[contains(text(),'White Papers')]");
  //public static final By HOME_RESOURCE_WHITEPAPERS_DATABASE = By.xpath("//div[@class='resourceSubCategoryTitle']");
	
    public static final By HOME_RESOURCE_WHITEPAPERS_DATABASE = By.xpath(".//*[@id='resourcesMenu']/div/div/div[1]/li/ul/li[11]/a");
    public static final By HOME_RESOURCE_WHITEPAPERS_DATABASE_TXT = By.xpath(".//*[@id='resources-banner-section']/div/div/div/div/div[2]/h1");
    
    
    /* Below locators are getting used for  C9_LandingPage_17_Resources_GettingStarted_Test
	 * 
	 */
    
//public static final By HOME_RESOURCE_DOCUMENTATION = By.xpath("//td[@class='sectionEntry']/a[text()='Documentation']");
//	public static final By HOME_RESOURCE_DOCUMENTATION_TXT = By.xpath("//h1[text()='Oracle Applications Cloud Services']");
//public static final By HOME_RESOURCE_DOCUMENTATION_TXT = By.xpath("//div[@id='productName']");
//	public static final By HOME_RESOURCE_DOCUMENTATION_TXT1 = By.xpath(".//*[@id='contentcolumn8']/h1/span");
//	public static final By HOME_RESOURCE_DOWNLOADS = By.xpath("//a[contains(@href,'downloads')]");
//	public static final By HOME_RESOURCE_DOWNLOADS_TXT = By.xpath("//div[@class='orcl6w3']/h1");
//	public static final By HOME_RESOURCE_FORUMS = By.xpath("//td/a[contains(text(),'Forums')]");
//	public static final By HOME_RESOURCE_FORUMS_TXT = By.xpath("//div[text()='Oracle Cloud']");
//	public static final By HOME_RESOURCE_FORUMS_SUPPORT = By.xpath("//td/a[contains(text(),'Support')]");
//	public static final By HOME_RESOURCE_FORUMS_SUPPORT_TXT = By.xpath("//div/a[contains(text(),'Oracle Cloud Services')]");
//	public static final By HOME_RESOURCE_TRAINING = By.xpath("//td/a[contains(text(),'Training')]");
	//public static final By HOME_RESOURCE_TRAINING_TXT = By.xpath("//ul[@id='sSpot']/li/h1");
    
    public static final By HOME_RESOURCE_Business_Users = By.xpath(".//*[@id='resourcesMenu']/div/div/div[2]/li/ul/li[1]/a");
    public static final By HOME_RESOURCE_Business_Users_txt = By.xpath("//div/h5[contains(text(),'Documentation / Help')]");
    public static final By HOME_RESOURCE_Developers = By.xpath(".//*[@id='resourcesMenu']/div/div/div[2]/li/ul/li[2]/a");
    public static final By HOME_RESOURCE_Developers_txt = By.xpath("//div/h5[contains(text(),'Documentation')]");
    
	public static final By HOME_RESOURCE_TRAINING_TXT = By.xpath("//div[@id='sSpotWrapper']/ul/li/h1");
	public static By Home_Customer_Exp1= By.xpath("//div[text()='Engage Customers']");
	
	 /* Below locators are getting used for  C9_LandingPage_19_Configure_Price_Quote_Test
		 * 
		 */
	
	public static final By Home_Configure_Service= By.xpath("//a[@href='/cpq']");
	public static final By Home_Configure_Service_overview_title= By.xpath("//div[text() = 'Increase Sales Efficiency']");
	public static final By Home_Configure_Service_pricing_title= By.xpath("//span[contains(text(),'Standard Edition')]");
	public static final By Home_Configure_Service_Customer_title= By.xpath("//div[contains(text(),'CPQ Cloud Case Studies')]");
	
	/* Below locators are getting used for  C9_LandingPage_20_Data_Test
	 * 
	 */
	
	public static final By Home_Data_Service= By.xpath("//div/a/span[contains(text(),'Data')]");
	public static final By Home_Data_Service_overview_txt= By.xpath("//div[contains(text(),'Data Informing Smarter Actions Everywhere')]");
	public static final By Home_Data_Service_Marketing= By.xpath("//li/a[contains(text(),'DaaS for Marketing')]");
	public static final By Home_Data_Service_Marketing_txt= By.xpath("//div[contains(text(),'Introducing: Data as a Service for Marketing')]");
	public static final By Home_Daas_for_social= By.xpath("//li/a[contains(text(),'DaaS for Social')]");
	public static final By Home_Daas_for_social_txt= By.xpath("//div[contains(text(),'Data Ingestion')]");
	public static final By Home_Daas_for_social_data_insight= By.xpath("//li/a[contains(text(),'Social Data and Insight')]");
	public static final By Home_Daas_for_social_data_insight_txt= By.xpath("//div[contains(text(),'Get Smart About Your Customers and Contacts')]");
	
	
	
	
	

}
