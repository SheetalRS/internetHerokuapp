package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class LandPage {


		public WebDriver driver;
		public ABTestPage abtestpage;
		public AddRemoveElementsPage addremoveelepg;
		public BrokenImagesPage brokenimgpg;
		public CheckBoxesPage chkboxpg;
		public ContextMenuPage contextmenupg;
		public DisappearingElementsPage disappearelmpg;
		public DragAndDropPage draganddroppg;
		public ChallengingDOMPage challengingdompg;
		public DropdownPage dropdoenpg;
		public DynamicLoadingPage dynaloadpg;
		public DynamicControlsPage dynamiccontrolspg;
		public  EntryAdPage entryAddPg;
		public FileDownloadPage filedownloadpg;
		public FileUploadPage fileuploadpg;
		public FramesPage framepg;
		public FormAuthentiCationPage formAuthPg;
		public HorizontalSliderPage horizonsliderPg;
		public HoversPage hoversPg;
		public InfiniteScrollPage infinitescrlpg;
		public By ABTesting = By.cssSelector("a[href*='abtest']");
		public By AddRemoveElements = By.cssSelector("a[href*='add_remove_elements']");
		public By BasicAuth = By.cssSelector("a[href*='basic_auth']");
		public By brokenImages = By.cssSelector("a[href*='broken_images']");
		public By checkBoxes = By.cssSelector("a[href*='checkboxes']");
		public By contextMenu = By.cssSelector("a[href*='context_menu']");
		public By disappearingelm = By.cssSelector("a[href*='disappearing_elements']");
		public By draganddrop = By.cssSelector("a[href*='drag_and_drop']"); 
		public By challengingDom = By.cssSelector("a[href*='challenging_dom']"); 
		public By dropdown = By.cssSelector("a[href*='dropdown']");
		public By dynamicControls = By.cssSelector("a[href*='dynamic_controls']");
		public By dynamicLoading = By.cssSelector("a[href*='dynamic_loading']");
		public By entryadd = By.cssSelector("a[href*='entry_ad']");
		public By fileDownload = By.cssSelector("a[href*='download']");
		public By fileUpload = By.cssSelector("a[href*='upload']");
		public By frames = By.cssSelector("a[href*='frames']");
		public By formAuthentication = By.cssSelector("a[href*='login']");
		public By horizontal_slider = By.cssSelector("a[href*='horizontal_slider']");
		public By hovers =By.cssSelector("a[href*='hovers']");
		public By infiniteScroll =By.cssSelector("a[href*='infinite_scroll']");	
		
		public InfiniteScrollPage ClickInfiniteScroll() {
			driver.findElement(infiniteScroll).click();
			  return infinitescrlpg = new InfiniteScrollPage(driver);
		}
		
		public HoversPage ClickHovers() {
			driver.findElement(hovers).click();
			  return hoversPg = new HoversPage(driver);
		}
		
		public HorizontalSliderPage ClickHorizontalSlider() {
			driver.findElement(horizontal_slider).click();
			  return horizonsliderPg = new HorizontalSliderPage(driver);
		}
		public FormAuthentiCationPage ClickFormAuthentication() {
			driver.findElement(formAuthentication).click();
			  return formAuthPg = new FormAuthentiCationPage(driver);
		}
		
		public FramesPage ClickFrames() {
			driver.findElement(frames).click();
			  return framepg = new FramesPage(driver);
		}
		
		public FileUploadPage ClickfileUpload() {
			driver.findElement(fileUpload).click();
			  return fileuploadpg = new FileUploadPage(driver);
		}
		
		public FileDownloadPage ClickFileDownload() {
			driver.findElement(fileDownload).click();
			  return filedownloadpg = new FileDownloadPage(driver);
		}
		
		public EntryAdPage ClickEntryAd() {
			driver.findElement(entryadd).click();
			  return entryAddPg = new EntryAdPage(driver);
		}
		
		public DynamicLoadingPage ClickDynamicLoading() {
			driver.findElement(dynamicLoading).click();
			  return dynaloadpg = new DynamicLoadingPage(driver);
		}
		
		public DynamicControlsPage ClickDynamicControls() {
			driver.findElement(dynamicControls).click();
			  return dynamiccontrolspg = new DynamicControlsPage(driver);
		}
		
		
		public ABTestPage Click_ABTesting() {
			driver.findElement(ABTesting).click();
			  return  abtestpage= new ABTestPage(driver);
		}
		
		public DropdownPage Click_Dropdown() {
			driver.findElement(dropdown).click();
			  return  dropdoenpg= new DropdownPage(driver);
		}
		public ChallengingDOMPage Click_ChallengingDom() {
			driver.findElement(challengingDom).click();
			  return  challengingdompg= new ChallengingDOMPage(driver);
		}
		
		public AddRemoveElementsPage Click_AddRemoveElements() {
			 driver.findElement(AddRemoveElements).click();
			 return  addremoveelepg= new AddRemoveElementsPage(driver);
			 
			 
			
		}
		
		
		public String getLandPageTitle(){
			return driver.getTitle();
		}
		
		
		public void Click_BasicAuth()  {
			driver.findElement(BasicAuth).click();
			
		}
		
		
		public BrokenImagesPage Click_BrokenImages() {
			 driver.findElement(brokenImages).click();
			 return  brokenimgpg= new BrokenImagesPage(driver);
			 
			 
			
		}
		
		public CheckBoxesPage Click_CheckBoxes() {
			 driver.findElement(checkBoxes).click();
			 return  chkboxpg= new CheckBoxesPage(driver);
		
		}
		
		public ContextMenuPage Click_ContextMenu() {
			 driver.findElement(contextMenu).click();
			 return  contextmenupg= new ContextMenuPage(driver);
		
		}
		
		public DisappearingElementsPage Click_DisappearElm() {
			 driver.findElement(disappearingelm).click();
			 return  disappearelmpg= new DisappearingElementsPage(driver);
		
		}
		
		public DragAndDropPage Click_DragAndDrop() {
			 driver.findElement(draganddrop).click();
			 return  draganddroppg= new DragAndDropPage(driver);
		
		}
		public LandPage( WebDriver driver){
			this.driver=driver;
		}
	

}
