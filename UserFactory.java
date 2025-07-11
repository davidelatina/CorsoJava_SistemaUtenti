interface NotificationRecipient {
  void update(/* String messaggio */);
}

// Concrete Product
class User implements NotificationRecipient {

  String nome;

/*
  Strategy userAction;

  setStrategy(Strategy newStrategy) {
    this.userAction = newStrategy;
  }
*/

  User(String nome) {
    this.nome = nome;
  }

  public void update(/* String messaggio */) {
    /*
    System.out.println("L'utente " + this.nome + " ha ricevuto il messaggio: \n" + messaggio);
     */
  }

}

// 4. Creator: dichiara il Factory Method
abstract class UserCreator {
  // Factory Method: restituisce un Product
  public abstract User createUser(String nome);

}

// Concrete Creator verso User che ne è Concrete Product
class UserFactory extends UserCreator {
  @Override
  public User createUser(String nome) {
    return new User(nome);
  }
}


// esempio di utilizzo
/*
class FactoryMethodDemo {
  public static void main(String[] args) {
    UserCreator userCreator = new UserFactory();

  }
}
*/