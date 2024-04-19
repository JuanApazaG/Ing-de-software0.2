/*
Lab 008: Ingenieria de Software
Operacion con numeros complejos
@autor Juan Agustin Apaza Guzman
@version 0.1
@date 19/04/2024
*/

/* Según los mitos de la creación de las religiones abrahámicas, Adán y Eva fueron los primeros humanos que vagaron por la Tierra.

Tienes que hacer el trabajo de Dios. El método de creación debe devolver una matriz de longitud 2 que contenga objetos (que representen a Adán y Eva). El primer objeto de la matriz debe ser una instancia de la clase Man. El segundo debería ser una instancia de la clase Woman. Ambos objetos tienen que ser subclases de Human. Tu trabajo es implementar las Human, Man and Womanclases. */

public class God {
    public static Human[] create(){
      Human adam = new Man("Adam");
      Human eve = new Woman("Eve");
      return new Human[] {adam, eve};
    }
  }
  class Human {
      public String name;
      public Human(String name) {
          this.name = name;
      }
  }
  class Man extends Human {
      public Man(String name) {
          super(name);
      }
  }
  class Woman extends Human {
      public Woman(String name) {
          super(name);
      }
  }