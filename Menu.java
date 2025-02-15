import java.util.Scanner;
import java.util.Vector;


class Menu {
    public String inserimento,descrizione;
    
    static Vector<Menu> opzioniMenu = inizializzaMenu();
    
    Menu(String inserimento, String descrizione){
        this.inserimento = inserimento;
        this.descrizione = descrizione;
         
    }
    
    private static Vector<Menu> inizializzaMenu(){
        Vector<Menu> menu = new Vector<>();
        menu.add(new  Menu("-----", "-----"));
        menu.add(new Menu("1","Inserisci persona"));
        menu.add(new Menu("2","Togli persona"));
        menu.add(new Menu("3","Vedi persone"));
        menu.add(new Menu("4","Esci"));
        return menu;
    }
    

    public static void mostraMenu(){
        
        for(Menu opzione : opzioniMenu){
            System.out.println(opzione.inserimento + "-" + opzione.descrizione);
        }
    }
    
    public static void gestisciScelta(int scelta, Ospedale ospedale){
        Scanner scanner = new Scanner(System.in);
        switch (scelta) {
            case 1:
                System.out.println();
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Cognome: ");
                String cognome = scanner.nextLine();
                System.out.print("Età: ");
                int eta = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Codice gravità (verde/giallo/rosso): ");
                String codice = scanner.nextLine().toLowerCase();
                ospedale.aggiungiPersona(new Persona(nome,  cognome, codice, eta, false));
                System.out.println();
                break;
            case 2:
                System.out.println();
                System.out.print("Nome: ");
                String Nome = scanner.nextLine();
                System.out.print("Cognome: ");
                String Cognome = scanner.nextLine();
                ospedale.rimuoviPaziente(Nome, Cognome);
                System.out.println();
                break;
            case 3:
                System.out.println();
                ospedale.visualizzaPersone();
                System.out.println();
                break;
            case 4:
                System.out.println();
                System.out.println("Uscita...");
                break;
            default:
                System.out.println("Scelta non valida.");
        }
    }
}