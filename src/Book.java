import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String description;
    private double importPrice;
    private double exportPrice;
    private float  interest;
    private boolean bookStatus;

    public Book(){

    }
    public Book(int bookId, String bookName, String author, String description, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
    public void inputData(Scanner scanner){
//        1. Mã sách – (Tự động tăng)
           this.bookId = inputBookId();
//        2. Tên sách –  (Không được để trống)
           this.bookName = inputBookName(scanner);
//        3. Tác giả – Không được để trống
           this.author = inputAuthor(scanner);
//        4. Mô tả về sách – String (Không được để trống, ít nhất 10 ký tự)
           this.description = inputDescriptions(scanner);
//        5. Giá nhập – (phải lớn hơn 0)
           this.importPrice = inputImportPrice(scanner);
//        6. Giá xuất – (phải lớn hơn 1.2 lần giá nhập)
           this.exportPrice = inputExportPrice(scanner);
           this.interest = displayInterest();
//        7. Trạng thái – Boolean (mặc định là true)
           this.bookStatus = inputBookStatus(scanner);

    }

    public void updateBook(Scanner scanner){
//        2. Tên sách –  (Không được để trống)
        this.bookName = inputBookName(scanner);
//        3. Tác giả – Không được để trống
        this.author = inputAuthor(scanner);
//        4. Mô tả về sách – String (Không được để trống, ít nhất 10 ký tự)
        this.description = inputDescriptions(scanner);
//        5. Giá nhập – (phải lớn hơn 0)
        this.importPrice = inputImportPrice(scanner);
//        6. Giá xuất – (phải lớn hơn 1.2 lần giá nhập)
        this.exportPrice = inputExportPrice(scanner);
        this.interest = displayInterest();
//        7. Trạng thái – Boolean (mặc định là true)
        this.bookStatus = inputBookStatus(scanner);

    }

    public int inputBookId(){
        if (BookManagement.currenIndex == 0){
            return 1;
        }else {
            int idMax = BookManagement.arrBooks[0].getBookId();
            for (int i=1;i<BookManagement.currenIndex;i++){
                if (idMax <BookManagement.arrBooks[i].getBookId()){
                    idMax = BookManagement.arrBooks[i].getBookId();
                }
            }
            return idMax + 1;
        }
    }

    public String inputBookName(Scanner scanner) {
        System.out.println("Enter the book name: ");
        do {
            String bookName = scanner.nextLine();
            if (bookName.trim().length() > 0) {
                return bookName;
            } else {
                System.err.println("Book name cannot be empty, please try again");
            }
        }while (true);
    }

    public String inputAuthor(Scanner scanner){
        System.out.println("Enter the Author name");
        do {
             String authorName = scanner.nextLine();
             if (authorName.trim().length() >0){
                 return authorName;
             }else {
                 System.err.println("Author name cannot be empty, please try again");
             }
        }while (true);
    }

    public String inputDescriptions(Scanner scanner){
        System.out.println("Enter the descriptions about book");
        do {
             String descriptions = scanner.nextLine();
             if (descriptions.trim().length()>=10){
                 return descriptions;
             }else {
                 System.err.println("descriptions about book cannot br empty,least 10 characters");
             }
        }while (true);
    }

    public double inputImportPrice(Scanner scanner){
        System.out.println("Enter the import price of book");
        do {
             double importPrice = Double.parseDouble(scanner.nextLine());
             if (importPrice > 0){
                 return importPrice;
             }else {
                 System.err.println("Import price of book > 0");
             }
        }while (true);
    }

    public double inputExportPrice(Scanner scanner){
        System.out.println("Enter the export price of book");
        do {
            double exportPrice = Double.parseDouble(scanner.nextLine());
            if (exportPrice > (this.importPrice*1.2)){
               return exportPrice;
            }else {
                System.err.println("Export price of book must be greater than 1.2 times the import price");
            }
        }while (true);
    }

    public float displayInterest(){
       return (float) (this.exportPrice - this.importPrice);
    }

    public Boolean inputBookStatus(Scanner scanner){
        System.out.println("Enter the book status");
        do {
            String bookStatus = scanner.nextLine();
            if (bookStatus.equals("true")){
                return true;
            }else {
                System.err.println("Book status only input (true), please try again");
            }
        }while (true);
    }


    public void displayData(){
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Book ID\t\tBook Name\t\tAuthor\t\t\tDescription\t\t\tImport Price\t\tExport Price\t\tInterest\t\tBook Status");
        System.out.printf("%-12d%-16s%-17s%-20s%-20f%-20f%-17f%-20b\n",
                this.bookId, this.bookName, this.author, this.description, this.importPrice, this.exportPrice, this.interest,
                this.bookStatus);
    }
}

