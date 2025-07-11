interface NotificationRecipient {
  void update(String messaggio);
}
interface  Strategy {
   void execute();
}


//Implementazione concreta Cerchio
class CircleStategy implements Strategy {
    @Override
    public void execute() {
         System.out.println("Disegno un cerchio:");
        System.out.println("  ---  ");
        System.out.println(" -   - ");
        System.out.println("-     -");
        System.out.println(" -   - ");
        System.out.println("  ---  ");
    }
}

// Implementazione concreta Quadrato
class SquareStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.println("Disegno un quadrato:");
        System.out.println("-------");
        System.out.println("-     -");
        System.out.println("-     -");
        System.out.println("-     -");
        System.out.println("-------");
    }
}

abstract class ShapeDecorator implements Strategy {
    //interfaccia protetta
    protected Strategy decoratedShape;
    //costruttore con parametro interfaccia
    public ShapeDecorator(Strategy decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    //metodo che richiama metodo dell'interfaccia
    public void execute() {
        decoratedShape.execute();
    }
}

// Decorator concreto che aggiunge una cornice
class FramedShapeDecorator extends ShapeDecorator {

    //costruttore con metodo super dell'interfaccia
    public FramedShapeDecorator(Strategy decoratedShape) {
        super(decoratedShape);
    }

    //metodo decorator con metodo super e aggiunge 2 stampe extra
    @Override
    public void execute() {
        System.out.println("----- Inizio cornice -----");
        super.execute();
        System.out.println("----- Fine cornice -----");
    }
}
// Concrete Product
class User implements NotificationRecipient {

  String nome;


  Strategy userAction;

  void setStrategy(Strategy newStrategy) {
    this.userAction = newStrategy;
  }


  User(String nome) {
    this.nome = nome;
  }

  public void update(String messaggio) {
  
    System.out.println("L'utente " + this.nome + " ha ricevuto il messaggio: \n" + messaggio);
     
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