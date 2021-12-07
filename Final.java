import java.util.Scanner;
import java.sql.* ;

public class Final {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Connection connection = null;
        try { // create a database connection
            Statement statement;
            connection = DriverManager.getConnection("jdbc:sqlite:Stocks.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(15);
             // 15 second timeout
            int x = 0;
            boolean quit = false;
            while (!quit) {
                System.out.println("For admin use: ");
                //Admin uses
                System.out.println("\t-Enter 1 to add to Stocks ETF.");
                System.out.println("\t-Enter 2 to add to Crypto ETF.");
                System.out.println("\t-Enter 3 add a Currency from Forex ETF.");
                System.out.println("\t-Enter 4 to add a brokerage.");
                System.out.println("\t-Enter 5 to add a user.");
                System.out.println("\t-Enter 6 remove a stock from Stocks ETF.");
                System.out.println("\t-Enter 7 to remove from Crypto ETF.");
                System.out.println("\t-Enter 8 to remove from Currency ETF.");
                System.out.println("\t-Enter 9 to remove a brokerage.");
                System.out.println("\t-Enter 10 to remove a user.");
                System.out.println("\t-Enter 11 to update a stock in Stocks ETF.");
                System.out.println("\t-Enter 12 to update Crypto ETF.");
                System.out.println("\t-Enter 13 to update a currency from Forex ETF.");
                System.out.println("\t-Enter 0 to disconnect and quit.");

                //user uses
                System.out.println("For users: ");
                System.out.println("\t-Enter 14 to add to your watctlist");
                System.out.println("\t-Enter 15 to remove from your watchlist.");
                System.out.println("\t-Enter 16 to view the Stocks ETF");
                System.out.println("\t-Enter 17 to view the Crypto ETF.");
                System.out.println("\t-Enter 18 to to view the forex ETF");
                System.out.println("\t-Enter 19 to view your watchlist");
                System.out.println("\t-Enter 20 to search for a stock");
                System.out.println("\t-Enter 21 to search for a crypto");
                System.out.println("\t-Enter 0 to disconnect and quit.");
                x = Integer.parseInt(scan.nextLine());
                switch (x) {
                    case 1:{
                    //adding Stock
                        String ticker, name, added_by, type, date, market_cap = "";
                        double low, high, PE, div_rate = 0;
                        System.out.print("\nEnter stock ticker: ");
                        ticker = scan.nextLine();
                        System.out.print("\nEnter stock name: ");
                        name = scan.nextLine();
                        System.out.print("\nEnter stock low: ");
                        low = scan.nextDouble();   
                        System.out.print("\nEnter stock high: ");
                        high = scan.nextDouble();         
                        System.out.print("\nEnter your name: ");
                        added_by = scan.next();  
                        added_by += scan.next();  
                        System.out.print("\nEnter todays date(format: yyyy-mm-dd): ");
                        date = scan.next();    
                        System.out.print("\nEnter the market cap for the Stock: ");
                        market_cap = scan.next(); 
                        market_cap += scan.next();                   
                        System.out.print("\nEnter the stock's PE ratio: ");
                        PE = scan.nextDouble(); 
                        System.out.print("\nEnter the type of Stock(Ex: Growth, Safe, Div): ");
                        type = scan.next(); 
                        System.out.print("\nEnter the div rate of stock(if no dividend then enter 0): ");
                        div_rate = scan.nextDouble(); 
                        addStock(ticker, name, low, high, added_by, date, market_cap, PE, type, div_rate);
                        break;
                    }
                    case 2:{
                    //adding Crypto to ETF
                        String ticker, name, added_by, purpose, date, current_supply, max_supply = " ";
                        double low, high, dominance = 0;
                        Boolean mine = false; 
                        System.out.print("\nEnter crypto ticker: ");
                        ticker = scan.nextLine();
                        System.out.print("\nEnter crypto name: ");                            
                        name = scan.nextLine();
                        System.out.print("\nEnter crypto low: ");
                        low = scan.nextDouble();   
                        System.out.print("\nEnter crypto high: ");
                        high = scan.nextDouble();         
                        System.out.print("\nEnter your name: ");
                        added_by = scan.next();                              
                        added_by += scan.next();  
                        System.out.print("\nEnter todays date(format: yyyy-mm-dd): ");
                        date = scan.next();    
                        System.out.print("\nEnter the market dominace rate for this crypto: ");
                        dominance = scan.nextDouble(); 
                        System.out.print("\nEnter the current total supply for this crypto: ");                            
                        current_supply = scan.next();
                        current_supply += scan.next();   
                        System.out.print("\nEnter the max supply for this crypto(Enter unknown if no max supply): ");
                        max_supply += scan.next();                 
                        System.out.print("\nEnter the purpose of this crypto: ");
                        purpose = scan.next(); 
                        purpose += scan.next();  
                        System.out.print("\nEnter True or False. Is crypto mineable? ");
                        mine = scan.nextBoolean();                          
                        addCrypto(ticker, name, low, high, added_by, date, dominance, current_supply, max_supply, purpose, mine);
                        break;
                    }
                    case 4:{
                        String name, type = " ";
                        int fee = 0;
                        System.out.print("\nEnter name of brokerage: ");
                        name = scan.nextLine();
                        System.out.print("\nEnter type of brokerage: ");
                        type = scan.nextLine();
                        System.out.print("\nEnter fee for brokerage(enter 0 if none): ");
                        fee = scan.nextInt();
                        addBrokerage(name, type, fee);
                        break;
                    }
                    case 0: 
                    {
                        quit = true;
                        break;
                    }
                    default: 
                    {
                        System.out.println("Unknown input");
                    }
                }
            }
            connection.close();
            scan.close();
        } 
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        catch (NumberFormatException e) {
            System.err.println("Input is not a number.");
            try{
                connection.close();
            }
            catch(SQLException t){
                System.err.println(t.getMessage());
            }
            scan.close();
        }
    }





    public static void addStock(String ticker, String name, double low, double high, String added_by, String date, String market_cap, double PE, String type, double div_rate){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Stocks.db");
            Statement s = c.createStatement();
            String add = "INSERT into Stocks values(\'"+ticker+"\', \'"+name+"\', "+low+", "+high+", \'"+added_by+"\', \'"+date+"\', \'"+market_cap+"\', "+PE+", \'"+type+"\', "+div_rate+")";
            s.executeUpdate(add);
            System.out.println("Added stock: "+name);
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void addCrypto(String ticker, String name, double low, double high, String added_by, String date, Double dominance, String current_supply, String max_supply, String purpose, Boolean mine){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Stocks.db");
            Statement s = c.createStatement();
            String add = "INSERT into Crypto values(\'"+ticker+"\', \'"+name+"\', "+low+", "+high+", \'"+added_by+"\', \'"+date+"\', "+dominance+", \'"+current_supply+"\', \'"+max_supply+"\', \'"+purpose+"\', "+mine+")";
            s.executeUpdate(add);
            System.out.println("Added crypto: "+name);
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void addBrokerage(String name, String type, int fee){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Stocks.db");
            Statement s = c.createStatement();
            String add = "INSERT into Brokerage values(\'"+name+"\', \'"+type+"\', \'"+fee+"\')";
            s.executeUpdate(add);
            System.out.println("Added Brokerage: "+name);
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }
}
