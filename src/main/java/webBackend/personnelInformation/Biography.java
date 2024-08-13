package webBackend.personnelInformation;

import bases.WebBase;
import webBackend.general.Login;
import webBackend.general.MainMenu;
import webBackend.general.MenaModules;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import static utilities.WebHelper.*;

public class Biography extends WebBase {

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(id = "employee_code")
    WebElement empCode;
    @FindBy(xpath = "//div[contains(@onclick, 'biography.php')]")
    WebElement biographyPage;
    @FindBy(id = "deriction2_ifr")
    WebElement englishBiographyFrame;
    @FindBy(id = "deriction1_ifr")
    WebElement arabicBiographyFrame;
    @FindBy(id = "tinymce")
    WebElement bodyBiography;
    @FindBy(xpath = "//a[@id='deriction2_bold']//span[@class='mceIcon mce_bold']")
    WebElement boldBtn;
    @FindBy(xpath = "//a[@id='deriction1_bold']//span[@class='mceIcon mce_bold']")
    WebElement boldBtnAr;
    @FindBy(xpath = "//a[@id='deriction2_justifycenter']//span[@class='mceIcon mce_justifycenter']")
    WebElement centerText;
    @FindBy(xpath = "//a[@id='deriction1_justifycenter']//span[@class='mceIcon mce_justifycenter']")
    WebElement centerTextAr;
    @FindBy(xpath = "//a[@id='deriction2_underline']//span[@class='mceIcon mce_underline']")
    WebElement underLine;
    @FindBy(xpath = "//a[@id='deriction1_underline']//span[@class='mceIcon mce_underline']")
    WebElement underLineAr;
    @FindBy(id = "deriction2_fontsizeselect_text")
    WebElement fontSizeList;
    @FindBy(id = "deriction1_fontsizeselect_text")
    WebElement fontSizeListAr;
    @FindBy(xpath = "//iframe[contains(@id, 'mce_inlinepopups')]")
    WebElement insertImgFrame;
    @FindBy(xpath = "//a[@id='deriction2_image']//span[@class='mceIcon mce_image']")
    WebElement insertImgEng;
    @FindBy(xpath = "//a[@id='deriction1_image']//span[@class='mceIcon mce_image']")
    WebElement insertImgAr;


    SoftAssert softAssert = new SoftAssert();
    Login login;
    MenaModules menaModules;
    MainMenu mainMenu;
    PersonnelInformation personnelInformation;

    public void addBiography(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(biographyPage);
        hold(300);
        elementWaitAdvanced(By.id("deriction2_parent"));
        goToFrame(englishBiographyFrame);
        hold(300);
        setText(bodyBiography, Keys.chord(Keys.CONTROL, "a"));
        hold(200);
        setText(bodyBiography, Keys.BACK_SPACE);
        hold(500);
        driver.switchTo().parentFrame();
        clickOn(insertImgEng);
        goToFrame(insertImgFrame);
        hold(200);
        setText(driver.findElement(By.id("src")), "https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/Test-Logo.svg/783px-Test-Logo.svg.png");
        setText(driver.findElement(By.id("alt")), "Img Description Test English");
        setText(driver.findElement(By.id("title")), "Img Title Test");
        hold(500);
        clickOn(driver.findElement(By.id("insert")));
        hold(500);
        driver.switchTo().parentFrame();
        goToFrame(englishBiographyFrame);
        hold(200);
        setText(bodyBiography, "\n\n\n");
        setText(bodyBiography, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc feugiat rhoncus nisl a rutrum. Vestibulum a fringilla velit, nec faucibus massa. Quisque risus justo, luctus sed ligula vitae, congue tristique odio. Aliquam enim dolor, pretium in justo fringilla, tincidunt molestie diam. Cras tincidunt nunc est, ut consequat neque cursus vel. Maecenas sed mi ligula. Sed tempus leo eget tristique luctus.\n" +
                "\n" +
                "Phasellus aliquam posuere nibh egestas bibendum. Sed sollicitudin diam sit amet orci pretium semper. Etiam vel viverra justo, vitae hendrerit nunc. Duis faucibus quam non lacus posuere accumsan. Mauris malesuada fermentum lacinia. Maecenas laoreet ex sit amet elit pulvinar, id molestie enim luctus. Nunc nibh lacus, ornare luctus velit a, facilisis viverra libero. Morbi blandit nulla mollis libero pretium, gravida interdum dui dictum. Aliquam ut lorem mi. Vestibulum pretium dui ut est euismod, non feugiat nisl semper. Curabitur posuere augue quam, vitae egestas erat placerat vitae. Integer at ipsum eu dui tincidunt mollis id pellentesque augue.\n" +
                "\n" +
                "Proin vel mi mauris. Quisque a congue nisi, ac rutrum sem. In fermentum at magna et placerat. Donec faucibus finibus magna id dignissim. Vestibulum id interdum nulla. Aenean ut elementum leo, at aliquet ex. Nunc ut dignissim quam. Aenean diam nulla, pretium vitae arcu at, tincidunt condimentum est. Etiam eget urna eget magna vestibulum bibendum nec quis orci. Nam fermentum erat eget erat elementum accumsan. Maecenas pharetra ut augue sed pellentesque. Nullam aliquet maximus suscipit.\n" +
                "\n" +
                "Nulla facilisi. Duis imperdiet imperdiet sapien, sagittis laoreet felis tincidunt vel. Mauris vitae ligula libero. Aliquam pellentesque elit eu felis facilisis condimentum. Fusce vel tellus eget ex laoreet lacinia at sed arcu. Sed vitae auctor diam, ut cursus libero. Praesent ut enim venenatis, tempor erat sit amet, varius felis. Morbi sit amet tincidunt dui. Nunc semper ante et eleifend pellentesque. Donec sed cursus purus. Nam id venenatis lorem, sit amet egestas tellus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam id sollicitudin massa. Donec augue neque, faucibus at lectus ut, dictum tristique elit. Aenean sit amet tincidunt justo. Sed ut tortor ac enim ultricies lacinia nec id massa.");

        hold(300);
        setText(bodyBiography, Keys.chord(Keys.CONTROL, "a"));
        hold(200);
        driver.switchTo().parentFrame();
        clickOn(boldBtn);
        hold(200);
        clickOn(centerText);
        hold(200);
        clickOn(fontSizeList);
        hold(300);
        clickOn(driver.findElement(By.xpath("//table[@id='menu_deriction2_deriction2_fontsizeselect_menu_tbl']//span[@title='4 (14pt)']")));
        hold(300);
        clickOn(underLine);
        hold(300);
        scrollToElement(arabicBiographyFrame);
        goToFrame(arabicBiographyFrame);
        hold(300);
        setText(bodyBiography, Keys.chord(Keys.CONTROL, "a"));
        hold(200);
        setText(bodyBiography, Keys.BACK_SPACE);
        hold(500);
        driver.switchTo().parentFrame();
        clickOn(insertImgAr);
        goToFrame(insertImgFrame);
        hold(200);
        setText(driver.findElement(By.id("src")), "https://cdn.pixabay.com/photo/2014/06/03/19/38/board-361516__340.jpg");
        setText(driver.findElement(By.id("alt")), "Img Description Test Arabic");
        setText(driver.findElement(By.id("title")), "Img Title Test Arabic");
        hold(500);
        clickOn(driver.findElement(By.id("insert")));
        hold(500);
        driver.switchTo().parentFrame();
        goToFrame(arabicBiographyFrame);
        hold(200);
        setText(bodyBiography, "\n\n\n");
        setText(bodyBiography, "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، حيث يمكنك أن تولد مثل هذا النص أو العديد من النصوص الأخرى إضافة إلى زيادة عدد الحروف التى يولدها التطبيق.\n" +
                "إذا كنت تحتاج إلى عدد أكبر من الفقرات يتيح لك مولد النص العربى زيادة عدد الفقرات كما تريد، النص لن يبدو مقسما ولا يحوي أخطاء لغوية، مولد النص العربى مفيد لمصممي المواقع على وجه الخصوص، حيث يحتاج العميل فى كثير من الأحيان أن يطلع على صورة حقيقية لتصميم الموقع.\n" +
                "ومن هنا وجب على المصمم أن يضع نصوصا مؤقتة على التصميم ليظهر للعميل الشكل كاملاً،دور مولد النص العربى أن يوفر على المصمم عناء البحث عن نص بديل لا علاقة له بالموضوع الذى يتحدث عنه التصميم فيظهر بشكل لا يليق.\n" +
                "هذا النص يمكن أن يتم تركيبه على أي تصميم دون مشكلة فلن يبدو وكأنه نص منسوخ، غير منظم، غير منسق، أو حتى غير مفهوم. لأنه مازال نصاً بديلاً ومؤقتاً.");

        hold(300);
        setText(bodyBiography, Keys.chord(Keys.CONTROL, "a"));
        hold(200);
        driver.switchTo().parentFrame();
        clickOn(boldBtnAr);
        hold(200);
        clickOn(centerTextAr);
        hold(200);
        clickOn(fontSizeListAr);
        hold(300);
        clickOn(driver.findElement(By.xpath("//table[@id='menu_deriction1_deriction1_fontsizeselect_menu_tbl']//span[@title='4 (14pt)']")));
        hold(300);
        clickOn(underLineAr);
        hold(500);
        scrollToElement(empCode);
        hold(200);
        clickOn(saveBtn);
        hold(300);
        clickOn(biographyPage);
        hold(500);
        elementWaitAdvanced(By.id("deriction2_parent"));

        goToFrame(englishBiographyFrame);
        hold(300);

        softAssert.assertEquals(bodyBiography.getText().trim(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc feugiat rhoncus nisl a rutrum. Vestibulum a fringilla velit, nec faucibus massa. Quisque risus justo, luctus sed ligula vitae, congue tristique odio. Aliquam enim dolor, pretium in justo fringilla, tincidunt molestie diam. Cras tincidunt nunc est, ut consequat neque cursus vel. Maecenas sed mi ligula. Sed tempus leo eget tristique luctus." +
                "\n" +
                " Phasellus aliquam posuere nibh egestas bibendum. Sed sollicitudin diam sit amet orci pretium semper. Etiam vel viverra justo, vitae hendrerit nunc. Duis faucibus quam non lacus posuere accumsan. Mauris malesuada fermentum lacinia. Maecenas laoreet ex sit amet elit pulvinar, id molestie enim luctus. Nunc nibh lacus, ornare luctus velit a, facilisis viverra libero. Morbi blandit nulla mollis libero pretium, gravida interdum dui dictum. Aliquam ut lorem mi. Vestibulum pretium dui ut est euismod, non feugiat nisl semper. Curabitur posuere augue quam, vitae egestas erat placerat vitae. Integer at ipsum eu dui tincidunt mollis id pellentesque augue." +
                "\n" +
                " Proin vel mi mauris. Quisque a congue nisi, ac rutrum sem. In fermentum at magna et placerat. Donec faucibus finibus magna id dignissim. Vestibulum id interdum nulla. Aenean ut elementum leo, at aliquet ex. Nunc ut dignissim quam. Aenean diam nulla, pretium vitae arcu at, tincidunt condimentum est. Etiam eget urna eget magna vestibulum bibendum nec quis orci. Nam fermentum erat eget erat elementum accumsan. Maecenas pharetra ut augue sed pellentesque. Nullam aliquet maximus suscipit." +
                "\n" +
                " Nulla facilisi. Duis imperdiet imperdiet sapien, sagittis laoreet felis tincidunt vel. Mauris vitae ligula libero. Aliquam pellentesque elit eu felis facilisis condimentum. Fusce vel tellus eget ex laoreet lacinia at sed arcu. Sed vitae auctor diam, ut cursus libero. Praesent ut enim venenatis, tempor erat sit amet, varius felis. Morbi sit amet tincidunt dui. Nunc semper ante et eleifend pellentesque. Donec sed cursus purus. Nam id venenatis lorem, sit amet egestas tellus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam id sollicitudin massa. Donec augue neque, faucibus at lectus ut, dictum tristique elit. Aenean sit amet tincidunt justo. Sed ut tortor ac enim ultricies lacinia nec id massa.");

        softAssert.assertEquals(VerifyImage(driver.findElement(By.xpath("//img[@alt='Img Description Test English']"))), 200);

        driver.switchTo().parentFrame();
        goToFrame(arabicBiographyFrame);
        hold(300);

        softAssert.assertEquals(bodyBiography.getText().trim(), "هذا النص هو مثال لنص يمكن أن يستبدل في نفس المساحة، لقد تم توليد هذا النص من مولد النص العربى، حيث يمكنك أن تولد مثل هذا النص أو العديد من النصوص الأخرى إضافة إلى زيادة عدد الحروف التى يولدها التطبيق.\n" +
                "إذا كنت تحتاج إلى عدد أكبر من الفقرات يتيح لك مولد النص العربى زيادة عدد الفقرات كما تريد، النص لن يبدو مقسما ولا يحوي أخطاء لغوية، مولد النص العربى مفيد لمصممي المواقع على وجه الخصوص، حيث يحتاج العميل فى كثير من الأحيان أن يطلع على صورة حقيقية لتصميم الموقع.\n" +
                "ومن هنا وجب على المصمم أن يضع نصوصا مؤقتة على التصميم ليظهر للعميل الشكل كاملاً،دور مولد النص العربى أن يوفر على المصمم عناء البحث عن نص بديل لا علاقة له بالموضوع الذى يتحدث عنه التصميم فيظهر بشكل لا يليق.\n" +
                "هذا النص يمكن أن يتم تركيبه على أي تصميم دون مشكلة فلن يبدو وكأنه نص منسوخ، غير منظم، غير منسق، أو حتى غير مفهوم. لأنه مازال نصاً بديلاً ومؤقتاً.");

        softAssert.assertEquals(VerifyImage(driver.findElement(By.xpath("//img[@alt='Img Description Test Arabic']"))), 200);
        softAssert.assertAll();

    }

    public void deleteBiography(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(biographyPage);
        hold(300);
        elementWaitAdvanced(By.id("deriction2_parent"));
        goToFrame(englishBiographyFrame);
        hold(300);
        setText(bodyBiography, Keys.chord(Keys.CONTROL, "a"));
        hold(200);
        setText(bodyBiography, Keys.BACK_SPACE);
        hold(500);
        driver.switchTo().parentFrame();
        scrollToElement(arabicBiographyFrame);
        goToFrame(arabicBiographyFrame);
        hold(300);
        setText(bodyBiography, Keys.chord(Keys.CONTROL, "a"));
        hold(200);
        setText(bodyBiography, Keys.BACK_SPACE);
        hold(500);
        driver.switchTo().parentFrame();
        hold(200);
        scrollToElement(empCode);
        hold(200);
        clickOn(saveBtn);
        hold(300);
        clickOn(biographyPage);
        hold(500);
        elementWaitAdvanced(By.id("deriction2_parent"));

        goToFrame(englishBiographyFrame);
        hold(300);

        softAssert.assertTrue(bodyBiography.getText().trim().isEmpty());

        driver.switchTo().parentFrame();
        goToFrame(arabicBiographyFrame);
        hold(300);

        softAssert.assertTrue(bodyBiography.getText().trim().isEmpty());
        softAssert.assertAll();

    }

    public void editBiography(){

        login = new Login();
        login.staticLogin();

        menaModules = new MenaModules();
        menaModules.menaPAY();

        mainMenu = new MainMenu();
        mainMenu.mainMenu("Employees","Personnel Information");

        personnelInformation = new PersonnelInformation();
        personnelInformation.personalInformation("Single", "Male", "Jordanian",
                "", "", "", "", "01/10/1990");

        personnelInformation.employmentInformation("Amman", "Quality", "Quality Control", "",
                "", "", "", "", "", "", "", "",
                "", "", "", "", "", "Software Test Engineer",
                "01/01/2020", "01/01/2020", "", "", "", "");

        clickOn(biographyPage);
        hold(300);
        elementWaitAdvanced(By.id("deriction2_parent"));
        goToFrame(englishBiographyFrame);
        hold(300);
        setText(bodyBiography, Keys.chord(Keys.CONTROL, "a"));
        hold(200);
        setText(bodyBiography, Keys.BACK_SPACE);
        hold(200);
        setText(bodyBiography, "Nam volutpat est lorem, in euismod dolor luctus vel. Proin malesuada in leo non aliquam. Donec eget mi ac nisi tincidunt dignissim. Praesent a lorem lacus. Nam iaculis a nunc ut dapibus. Vestibulum volutpat fringilla egestas. Donec ut dictum risus, vestibulum blandit sapien. Sed tortor arcu, mollis vel placerat ultricies, commodo vitae metus. Proin in molestie dolor, ut viverra erat. Fusce interdum hendrerit metus.");
        hold(500);
        driver.switchTo().parentFrame();
        scrollToElement(arabicBiographyFrame);
        goToFrame(arabicBiographyFrame);
        hold(300);
        setText(bodyBiography, Keys.chord(Keys.CONTROL, "a"));
        hold(200);
        setText(bodyBiography, Keys.BACK_SPACE);
        hold(200);
        setText(bodyBiography, "هذا النص يمكن أن يتم تركيبه على أي تصميم دون مشكلة فلن يبدو وكأنه نص منسوخ، غير منظم، غير منسق، أو حتى غير مفهوم. لأنه مازال نصاً بديلاً ومؤقتاً.");
        hold(500);
        driver.switchTo().parentFrame();
        hold(200);
        scrollToElement(empCode);
        hold(200);
        clickOn(saveBtn);
        hold(300);
        clickOn(biographyPage);
        hold(500);
        elementWaitAdvanced(By.id("deriction2_parent"));

        goToFrame(englishBiographyFrame);
        hold(300);

        softAssert.assertEquals(bodyBiography.getText().trim(), "Nam volutpat est lorem, in euismod dolor luctus vel. Proin malesuada in leo non aliquam. Donec eget mi ac nisi tincidunt dignissim. Praesent a lorem lacus. Nam iaculis a nunc ut dapibus. Vestibulum volutpat fringilla egestas. Donec ut dictum risus, vestibulum blandit sapien. Sed tortor arcu, mollis vel placerat ultricies, commodo vitae metus. Proin in molestie dolor, ut viverra erat. Fusce interdum hendrerit metus.");

        driver.switchTo().parentFrame();
        goToFrame(arabicBiographyFrame);
        hold(300);

        softAssert.assertEquals(bodyBiography.getText().trim(), "هذا النص يمكن أن يتم تركيبه على أي تصميم دون مشكلة فلن يبدو وكأنه نص منسوخ، غير منظم، غير منسق، أو حتى غير مفهوم. لأنه مازال نصاً بديلاً ومؤقتاً.");
        softAssert.assertAll();

    }
}
