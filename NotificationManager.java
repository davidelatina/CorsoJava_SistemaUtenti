 import java.util.*;
 // Interfaccia  del subject
interface NotificationManagerInterface{
     public void aggiungiUtente(User utente);
     public void rimuoviutente(User utente);
     public void notificaDisplay();
    // void setCambiamento(String nome);
}

//classe Subject con Singleton
class  NotificationManager implements NotificationManagerInterface{
    //istanza statica per singleton
    private static NotificationManager instance;
    //List di Observer
    private List<User> utenti;

    public void setCambiamento(){
        
        notificaDisplay();
    }

    //costruttore privato per fare in modo che non sia richiamabile
    private NotificationManager() {};

    //metodo statico èer creare un istanza singola
    public static NotificationManager getInstance() {
        if (instance == null) {
            NotificationManager instance = new NotificationManager();
            instance.utenti = new ArrayList<>();

        }
        return instance;
    }

    //metodo per aggiungere observer
    public void aggiungiUtente(User utente) {
        utenti.add(utente);
    }

    //metodo per rimuovere observer
    public void rimuoviUtente(String utente) {
        for (User user : utenti) {
            if(user.nome.equals(utente)){
                utenti.remove(utente);
            }}
    }

    //metodo che esegue nuovo ordine e notifica gli observer
    public void notificaDisplay(String messaggio) {
        for (User utente  : utenti) {
            utente.update(messaggio);
        }
    }
}