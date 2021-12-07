import java.util.Scanner;
import java.sql.* ;

public class Final {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Connection connection = null;
        try { // create a database connection
            Statement statement;
            connection = DriverManager.getConnection("jdbc:sqlite:Trading.db");
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
                System.out.println("\t-Enter 5 remove a stock from Stocks ETF.");
                System.out.println("\t-Enter 6 to remove from Crypto ETF.");
                System.out.println("\t-Enter 7 to remove from Currency ETF.");
                System.out.println("\t-Enter 8 to remove a brokerage.");
                System.out.println("\t-Enter 9 to update a stock in Stocks ETF.");
                System.out.println("\t-Enter 10 to update Crypto ETF.");
                System.out.println("\t-Enter 11 to update a currency from Forex ETF.");
                System.out.println("\t-Enter 0 to disconnect and quit.");

                //user uses
                System.out.println("\nFor users: ");
                System.out.println("\t-Enter 12 to add to your watctlist");
                System.out.println("\t-Enter 13 to remove from your watchlist.");
                System.out.println("\t-Enter 14 to view the Stocks ETF");
                System.out.println("\t-Enter 15 to view the Crypto ETF.");
                System.out.println("\t-Enter 16 to to view the forex ETF");
                System.out.println("\t-Enter 17 to view your watchlist");
                System.out.println("\t-Enter 18 to search for a stock");
                System.out.println("\t-Enter 19 to search for a crypto");
                System.out.println("\t-Enter 20 to create an account.");
                System.out.println("\t-Enter 0 to disconnect and quit.");
               // x = Integer.parseInt(scan.nextLine());
               x = scan.nextInt();
                switch (x) {
                    case 1:{
                    //adding Stock
                        String ticker, name, added_by, type, date, market_cap, PE = "";
                        double low, high, div_rate = 0;
                        System.out.print("\nEnter stock ticker: ");
                        ticker = scan.next();
                        System.out.print("\nEnter stock name: ");
                        name = scan.next();
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
                        PE = scan.next(); 
                        System.out.print("\nEnter the type of Stock(Ex: Growth, Safe, Div): ");
                        type = scan.next(); 
                        System.out.print("\nEnter the div rate of stock(if no dividend then enter 0): ");
                        div_rate = scan.nextDouble(); 
                        addStock(ticker, name, low, high, added_by, date, market_cap, PE, type, div_rate);
                        break;
                    }
                    case 2:{
                    //adding Crypto to ETF
                        String ticker, name, added_by, purpose, date, current_supply, max_supply, mine = " ";
                        double low, high, dominance = 0;
                        System.out.print("\nEnter crypto ticker: ");
                        ticker = scan.next();
                        System.out.print("\nEnter crypto name: ");                            
                        name = scan.next();
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
                        max_supply = scan.next();   
                        max_supply += scan.next();                 
                        System.out.print("\nEnter the purpose of this crypto: ");
                        purpose = scan.next(); 
                        purpose += scan.next();  
                        System.out.print("\nEnter True or False. Is crypto mineable? ");
                        mine = scan.next();                          
                        addCrypto(ticker, name, low, high, added_by, date, dominance, current_supply, max_supply, purpose, mine);
                        break;
                    }
                    case 3: {
                    //adding forex
                        String comp, code, added_by, added_date = " ";
                        double price = 0;
                        System.out.print("\nEnter the currency code(EX: USD/JPY): ");
                        code = scan.next();
                        System.out.print("\nEnter the currency to compare with: ");
                        comp = scan.next();                
                        System.out.print("\nEnter the currency comparsion rate: ");
                        price = scan.nextDouble();
                        System.out.print("\nEnter your name: ");
                        added_by = scan.next();                              
                        added_by += scan.next();  
                        System.out.print("\nEnter todays date(format: yyyy-mm-dd): ");
                        added_date = scan.next();    
                        addForex(code, comp, price, added_by, added_date);
                        break;
                    }
                    case 4:{
                    //adding brokerage
                        String name, type = " ";
                        int fee = 0;
                        System.out.print("\nEnter name of brokerage: ");
                        name = scan.next();
                        System.out.print("\nEnter type of brokerage: ");
                        type = scan.next();
                        System.out.print("\nEnter fee for brokerage(enter 0 if none): ");
                        fee = scan.nextInt();
                        addBrokerage(name, type, fee);
                        break;
                    }
                    case 5:{
                    //Delete stock
                        String ticker = " ";
                        System.out.print("\nEnter the ticker of stock to remove: ");
                        ticker = scan.next();
                        removeStock(ticker);
                        break;
                    }
                    case 6:{
                    // Delete Crypto
                        String ticker = " ";
                        System.out.print("\nEnter the ticker of crypto to remove: ");
                        ticker = scan.next();
                        removeCrypto(ticker);
                        break;
                    }
                    case 7:{
                    //Delete currency
                        String code = " ";
                        System.out.print("\nEnter the currency code of currency to remove(EX: USD/CNY): ");
                        code = scan.next();
                        removeCurrency(code);
                        break;
                    }  
                    case 8:{
                    //Delete Brokerage
                        String name = " ";
                        System.out.print("\nEnter the name of Brokerage to remove: ");
                        name = scan.next();
                        removeBrokerage(name);
                        break;
                    }
                    case 9: {
                    //Update stock
                        String ticker, added_by, date, market_cap, PE = "";
                        double low, high, div_rate = 0;
                        System.out.print("\nEnter stock ticker you want to update: ");
                        ticker = scan.next();
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
                        PE = scan.next(); 
                        System.out.print("\nEnter the div rate of stock(if no dividend then enter 0): ");
                        div_rate = scan.nextDouble(); 
                        updateStock(ticker, low, high, added_by, date, market_cap, PE, div_rate);
                        break;
                    }     
                    case 10:{
                    //Update Crypto to ETF
                        String ticker, added_by, date, current_supply, mine = " ";
                        double low, high, dominance = 0;
                        System.out.print("\nEnter crypto ticker you want to update: ");
                        ticker = scan.next();
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
                        System.out.print("\nEnter True or False. Is crypto mineable? ");
                        mine = scan.next();                          
                        updateCrypto(ticker, low, high, added_by, date, dominance, current_supply, mine);
                        break;
                    }
                    case 11: {
                    //Update forex
                        String comp, code, added_by, added_date = " ";
                        double price = 0;
                        System.out.print("\nEnter the currency code you want to update: ");
                        code = scan.next();
                        System.out.print("\nEnter the currency: ");
                        comp = scan.next();                
                        System.out.print("\nEnter the currency comparsion rate: ");
                        price = scan.nextDouble();
                        System.out.print("\nEnter your name: ");
                        added_by = scan.next();                              
                        added_by += scan.next();  
                        System.out.print("\nEnter todays date(format: yyyy-mm-dd): ");
                        added_date = scan.next();    
                        updateForex(code, comp, price, added_by, added_date);
                        break;
                    } 
                    case 12: {
                    //add to watchlist
                        String ticker = "";
                        int id;
                        System.out.print("\nEnter you id number: ");
                        id = scan.nextInt();
                        System.out.print("\nEnter the ticker you want to add to your watchlist: ");
                        ticker = scan.next();
                        addWatchlist(id, ticker);
                        break;
                    }       
                    case 13: {
                    //remove to watchlist
                        String ticker = "";
                        int id;
                        System.out.print("\nEnter you id number: ");
                        id = scan.nextInt();
                        System.out.print("\nEnter the ticker you want to remove to your watchlist: ");
                        ticker = scan.next();
                        deleteWatchlist(id, ticker);
                        break;
                    }
                    case 14: {
                    // print Stocks table
                       printStocks();
                       break; 
                    }
                    case 15: {
                    //print crypto etf
                    System.out.println();
                    System.out.println("\nCrypto ETF:");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%5s %20s %10s %10s %15s %15s %15s %15s %15s %15s %20 ", "ticker", "name", "low", "high", "added_by", "added_date", "market_dom", "current_supply", "max_supply", "purpose", "mine");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
                    String sql = " Select * from Crytpo";
                    Statement s =connection.createStatement();
                    ResultSet r =s.executeQuery(sql);
                    while(r.next()){
                        String ticker = r.getString(1);
                        String name = r.getString(2); 
                        double low = r.getDouble(3);
                        double high = r.getDouble(4);   
                        String added_by = r.getString(5);
                        String added_date = r.getString(6);
                        double market_dom = r.getDouble(7);
                        String current_supply = r.getString(8);
                        String max_supply = r.getString(9);   
                        String purpose = r.getString(10);
                        String mine = r.getString(11);
                        System.out.printf("%5s %20s %10s %10s %15s %15s %15s %15s %15s %15s %20s", ticker, name, low, high, added_by, added_date, market_dom, current_supply, max_supply, purpose, mine);
                        System.out.println();
                    }
                    break;
                        
                    } 
                    case 16: {
                        
                    } 
                    case 17: {
                    //Print your watchlist
                        int id = 0;
                        System.out.println("\nEnter you id number: ");
                        id = scan.nextInt();
                        System.out.println("\nWatchlist: ");
                        System.out.println("id       ticker");
                        String sql = "Select * from Watchlist Where id = "+id;
                        Statement s =connection.createStatement();
                        ResultSet r =s.executeQuery(sql);
                        while(r.next()){
                            int idd = r.getInt(1);
                            String ticker = r.getString(2);
                            System.out.println(idd+"          "+ticker);
                        }  
                    } 
                    case 18: {
                    //find stock
                        String ticker = "";
                        System.out.println("Enter the ticker of the stock you wish to find: ");
                        ticker = scan.next();
                        findStock(ticker);
                        break;
                    } 
                    case 19: {
                    //find crypto
                        String ticker = "";
                        System.out.println("Enter the ticker of the crypto you wish to find: ");
                        ticker = scan.next();
                        findCrypto(ticker);
                        break;    
                    } 
                    case 20: {
                        
                    }           
                    case 0: {
                        quit = true;
                        break;
                    }
                    default: {
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
    }





    public static void addStock(String ticker, String name, double low, double high, String added_by, String date, String market_cap, String PE, String type, double div_rate){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            String add = "INSERT into Stocks values(\'"+ticker+"\', \'"+name+"\', "+low+", "+high+", \'"+added_by+"\', \'"+date+"\', \'"+market_cap+"\', \'"+PE+"\', \'"+type+"\', "+div_rate+")";
            s.executeUpdate(add);
            System.out.println("Added stock: "+name);
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void addCrypto(String ticker, String name, double low, double high, String added_by, String date, Double dominance, String current_supply, String max_supply, String purpose, String mine){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            String add = "INSERT into Crypto values(\'"+ticker+"\', \'"+name+"\', "+low+", "+high+", \'"+added_by+"\', \'"+date+"\', "+dominance+", \'"+current_supply+"\', \'"+max_supply+"\', \'"+purpose+"\', \'"+mine+"\')";
            s.executeUpdate(add);
            System.out.println("Added crypto: "+name);
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void addForex(String code, String comp, double price, String added_by, String added_date){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            String add = "INSERT into Forex values(\'"+code+"\', \'"+comp+"\', "+price+", \'"+added_by+"\', \'"+added_date+"\')";
            s.executeUpdate(add);
            System.out.println("Added forex: "+code);
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void addBrokerage(String name, String type, int fee){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            String add = "INSERT into Brokerage values(\'"+name+"\', \'"+type+"\', "+fee+")";
            s.executeUpdate(add);
            System.out.println("Added Brokerage: "+name);
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void removeStock(String ticker){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            String remove = "DELETE FROM Stocks where ticker = \'"+ticker+"\'";
            s.executeUpdate(remove);
            System.out.println("Removed Stock: "+ticker);
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void removeCrypto(String ticker){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            String remove = "DELETE FROM Crypto where ticker = \'"+ticker+"\'";
            s.executeUpdate(remove);
            System.out.println("Removed Crypto: "+ticker);
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void removeCurrency(String code){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            String remove = "DELETE FROM Forex where currency_code = \'"+code+"\'";
            s.executeUpdate(remove);
            System.out.println("Removed Forex: "+code);
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void removeBrokerage(String name){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            String remove = "DELETE FROM Brokerage where name = \'"+name+"\'";
            s.executeUpdate(remove);
            System.out.println("Removed Brokerage: "+name);
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void updateStock(String ticker, double low, double high, String added_by, String added_date, String market_cap, String PE, double div_rate){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
 /*         String sql = "SELECT name, type FROM Stocks where ticker = "+ticker;
            ResultSet r = s.executeQuery(sql);
            String name = r.getString(2);
            String type = r.getString(9);
            */
            String update = "Update Stocks SET low = "+low+", high = "+high+", added_by = \'"+added_by+"\', added_date = \'"+added_date+"\', market_cap = \'"+market_cap+"\', PE = \'"+PE+"\', div_rate = "+div_rate+" WHERE ticker = \'"+ticker+"\'";
            s.executeUpdate(update);
            System.out.println("Updated stock: "+ticker);
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void updateCrypto(String ticker, double low, double high, String added_by, String added_date, double market_dom, String current_supply, String mine){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            String update = "Update Crypto SET low = "+low+", high = "+high+", added_by = \'"+added_by+"\', added_date = \'"+added_date+"\', market_dom = "+market_dom+", current_supply = \'"+current_supply+"\', mine = \'"+mine+"\' WHERE ticker = \'"+ticker+"\'";
            s.executeUpdate(update);
            System.out.println("Updated crypto: "+ticker);
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void updateForex(String code, String comp, double price, String added_by, String added_date){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            String update = "Update Forex SET currency_code = \'"+code+"\', currency = \'"+comp+"\', Price = "+price+", added_by = \'"+added_by+"\', added_date = \'"+added_date+"\' WHERE currency_code = \'"+code+"\'";
            s.executeUpdate(update);
            System.out.println("Updated Forex: "+code);
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void addWatchlist(int id, String ticker){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            String add = "INSERT into Watchlist values("+id+", \'"+ticker+"\')";
            s.executeUpdate(add);
            System.out.println("Added ticker, "+ticker+", to user "+id+" watchlist");
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void deleteWatchlist(int id, String ticker){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            String remove = "DELETE from Watchlist WHERE id = "+id+" and ticker = \'"+ticker+"\'";
            s.executeUpdate(remove);
            System.out.println("Removed ticker, "+ticker+", to user "+id+" watchlist");
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void printStocks(){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            System.out.println();
            System.out.println("\nStocks ETF:");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%5s %20s %10s %10s %15s %15s %15s %10s %10s %10s ", "ticker", "name", "low", "high", "added_by", "added_date", "market_cap", "PE", "type", "div_rate");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            //  System.out.println("\nticker        name     low     high        added_by        added_date          market_cap      PE      type    div_rate ");
            String sql = " Select * from Stocks";
            ResultSet r =s.executeQuery(sql);
            while(r.next()){
                String ticker = r.getString(1);
                String name = r.getString(2); 
                double low = r.getDouble(3);
                double high = r.getDouble(4);   
                String added_by = r.getString(5);
                String added_date = r.getString(6);
                String market_cap = r.getString(7);
                String PE = r.getString(8);
                String type = r.getString(9);   
                double div_rate = r.getDouble(10);
                System.out.printf("%5s %20s %10s %10s %15s %15s %15s %10s %10s %10s", ticker, name, low, high, added_by, added_date, market_cap, PE, type, div_rate);
                System.out.println();
            }
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void findStock(String ticker){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            System.out.printf("%5s %20s %10s %10s %15s %15s %15s %10s %10s %10s ", "ticker", "name", "low", "high", "added_by", "added_date", "market_cap", "PE", "type", "div_rate");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            String sql = " Select * from Stocks where ticker = \'"+ticker+"\'";
            ResultSet r =s.executeQuery(sql);
            while(r.next()){
                //String ticker = r.getString(1);
                String name = r.getString(2); 
                double low = r.getDouble(3);
                double high = r.getDouble(4);   
                String added_by = r.getString(5);
                String added_date = r.getString(6);
                String market_cap = r.getString(7);
                String PE = r.getString(8);
                String type = r.getString(9);   
                double div_rate = r.getDouble(10);
                System.out.printf("%5s %20s %10s %10s %15s %15s %15s %10s %10s %10s", ticker, name, low, high, added_by, added_date, market_cap, PE, type, div_rate);
                System.out.println();
            }
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void findCrypto(String ticker){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            System.out.printf("%5s %20s %10s %10s %15s %15s %15s %10s %10s %10s %10s ", "ticker", "name", "low", "high", "added_by", "added_date", "market_dom", "current_supply", "max_supply", "purpose", "mine");
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            String sql = " Select * from Crypto where ticker = \'"+ticker+"\'";
            ResultSet r =s.executeQuery(sql);
            while(r.next()){
                //String ticker = r.getString(1);
                String name = r.getString(2); 
                double low = r.getDouble(3);
                double high = r.getDouble(4);   
                String added_by = r.getString(5);
                String added_date = r.getString(6);
                double market_dom = r.getDouble(7);
                String current_supply = r.getString(8);
                String max_supply = r.getString(9);   
                String purpose = r.getString(10); 
                String mine = r.getString(11); 
                System.out.printf("%5s %20s %10s %10s %15s %15s %15s %10s %10s %10s %10", ticker, name, low, high, added_by, added_date, market_dom, current_supply, max_supply, purpose, mine);
                System.out.println();
            }
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static void addUser(String name, String type){
        Connection c=null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:Trading.db");
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("SELECT count(*) as total FROM Users");
            int total = r.getInt("total");
            total = total + 1; 
            String add = "INSERT into Users values("+total+", \'"+name+"\', \'user\', \'"+type+"\')";
            s.executeUpdate(add);
            System.out.println("Added User: "+name+" with id: "+total);
            c.close();
        }
        catch(SQLException e){
        System.err.println("ERROR: " + e.getMessage());
        }
    }
}
