import java.util.Scanner;

public class BookManagement {
    public static Book[] arrBooks = new Book[100];
    public static int currenIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("**************MENU**************************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách " );
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện ");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần ");
            System.out.println("4. Xóa sách theo mã sách ");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả ");
            System.out.println("6. Thay đổi thông tin sách theo mã sách ");
            System.out.println("7. Thoát");
            System.out.print("Enter your choice: \n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    BookManagement.inputBookList(scanner);
                    break;
                case 2:
                    BookManagement.displayBookList();
                    break;
                case 3:
                    BookManagement.sortBookByInterest(scanner);
                    break;
                case 4:
                    BookManagement.deleteBook(scanner);
                    break;
                case 5:
                     BookManagement.searchBookByName(scanner);
                    break;
                case 6:
                    BookManagement.updateBook(scanner);
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter choice from 1->7");
            }
        }while (true);
    }

    public static void inputBookList(Scanner scanner){
        System.out.println("Enter the number of books to enter information");
        int ctnBooks = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < ctnBooks ; i++) {
            System.out.println("Information of book : " +(i+1));
            arrBooks[currenIndex] = new Book();
            arrBooks[currenIndex].inputData(scanner);
            currenIndex++;
        }
    }

    public static void displayBookList(){
        for (int i = 0; i < currenIndex ; i++) {
            arrBooks[i].displayData();
        }
    }

    public static void sortBookByInterest(Scanner scanner){
        for (int i = 0; i < currenIndex-1 ; i++) {
            for (int j = i + 1; j < currenIndex ; j++) {
                if (arrBooks[i].getInterest() > arrBooks[j].getInterest()) {
                    Book temp = arrBooks[i];
                    arrBooks[i] = arrBooks[j];
                    arrBooks[j] = temp;
                }
            }
        }
        System.out.println("You have successfully arranged");

    }
  public static void deleteBook(Scanner scanner){
      System.out.println("Enter the Book Id to delete");
      int bookId = Integer.parseInt(scanner.nextLine());
      int indexDelete = getIndexById(bookId);
      if (indexDelete >= 0){
          for (int i = 0; i<currenIndex ; i++){
              arrBooks[i]=arrBooks[i+1];
          }
          currenIndex--;
      }else {
          System.err.println("The Book Id does not exist");
      }
  }

  public static int getIndexById(int bookId){
        for (int i = 0; i<currenIndex; i++){
            if (BookManagement.arrBooks[i].getBookId() == bookId){
                return i;
            }
        }return -1;
  }

  public static void searchBookByName(Scanner scanner){
      System.out.println("Enter the name or description of the book  you want to search for ");
      String bookNameSearch = scanner.nextLine().toLowerCase();
      int cntBook = 0;
      System.out.println("Books you need to find : ");
      for (int i =0; i<currenIndex; i++){
          if (arrBooks[i].getBookName().toLowerCase().contains(bookNameSearch)||
          arrBooks[i].getDescription().toLowerCase().contains(bookNameSearch)){
                arrBooks[i].displayData();
                cntBook++;
          }
      }
      System.out.println("Books number to find: " + cntBook);

  }
  public  static void updateBook(Scanner scanner){
      System.out.println(" Enter the Book Id to update");
      int bookId = Integer.parseInt(scanner.nextLine());
      int indexUpdate = getIndexById(bookId);
      if (indexUpdate>=0){
            for (int i = 0; i<currenIndex ; i++){
                if (arrBooks[i].getBookId() == bookId){
                    arrBooks[indexUpdate].updateBook(scanner);
                    break;
                }
            }
      }else {
          System.err.println("The Book Id does not exist");
      }
  }
}
