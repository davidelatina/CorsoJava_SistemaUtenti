import java.util.*;
//classe Facade  per gestire menu con input utente
class UserManagementFacade {
    //creazione oggetti Scanner , Legacy e adapter
    private Scanner scanner = new Scanner(System.in);
    private User user;
    UserFactory userFactory = new UserFactory();
    NotificationManager notificationManager = NotificationManager.getInstance();
    String input;
    
    //private LegacyUserSystem legacySystem;

    //costruttore con parametri
    public UserManagementFacade(User user) {
        //this.userManagement = userManagement;
    }

    //metodo per gestire menu
    public void avviaMenu() {

        System.out.println("Scegli nome");
        input = scanner.nextLine();
        user = userFactory.createUser(input);
        do {
            System.out.println("Scegli nome");
            input = scanner.nextLine();
            user = userFactory.createUser(input);
            notificationManager.aggiungiUtente(user);
            System.out.println("Comandi disponibili: 1 crea utente, 2 rimuovi utente,3  cambia azione o  0 esci");
            System.out.print("Inserisci comando: ");
            input = scanner.nextLine();

            switch (input) {
                case "0":
                    System.out.println("Chiusura programma.");
                    return;

                case "1":
                            System.out.println("Inserisci nome");
                            input = scanner.nextLine();
                            userFactory.createUser(input);
                case "2":
                            System.out.println("Inserisci nome");
                            input = scanner.nextLine();
                            notificationManager.rimuoviUtente(input);
                case "3":
                            scegliStrategia(utenteAttivo);

                default:
                    System.out.println("Comando non riconosciuto.");
            }
        } while (true);
    }

    //metodo per scegliere strategyy con input
    private void scegliStrategia(User utenteAttivo) {


        System.out.println("azioni disponibili:");
        System.out.println("1. stampa cerchio");
        System.out.println("2. stampa quadreato");
        System.out.print("Scegli una strategia (1 o 2): ");
        String scelta = scanner.nextLine();
        switch (scelta) {
            case "1"://imposta con strategia base

                break;
            case "2":

                break;
            default:
                System.out.println("Scelta non valida. Strategia invariata.");
        }
    }
}
