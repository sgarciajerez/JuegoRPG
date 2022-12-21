public class Personaje {

    private String nombre;
    private String Liga;
    private int vida;
    private int ataque;
    private int defensa;
    private int ataqueSpecial;
    private int defensaSpecial;
    private int velocidad;
    private int ataqueDisponible=1;

    public Personaje (String nombre, String Liga, int vida, int ataque, int defensa, int ataqueSpecial, int defensaSpecial, int velocidad){
        this.nombre=nombre;
        this.Liga=Liga;
        this.vida=vida;
        this.ataque=ataque;
        this.defensa=defensa;
        this.ataqueSpecial=ataqueSpecial;
        this.defensaSpecial=defensaSpecial;
        this.velocidad=velocidad;
    }

    public Personaje (String nombre, String Liga){
        this.nombre=nombre;
        this.Liga=Liga;
        this.vida= (int)(Math.random()*50+1);
        this.ataque= (int)(Math.random()*50+1);
        this.defensa= (int)(Math.random()*50+1);        
        this.ataqueSpecial= (int)(Math.random()*50+1);
        this.defensaSpecial=(int)(Math.random()*50+1);
        this.velocidad=(int)(Math.random()*50+1);
    }

    public String getNombre(){
        return this.nombre;
    }
    public String setNombre(String nombre){
        return this.nombre=nombre;
    }
    public String getLiga(){
        return this.Liga;
    }
    public String setLiga(String Liga){
        return this.Liga=Liga;
    }
    public int getVida(){
        return this.vida;
    }
    public int setVida (int vida){
        return this.vida=vida;
    }
    public int getAtaque(){
        return this.ataque;
    }
    public int setAtaque (int ataque){
        return this.ataque=ataque;
    }
    public int getDefensa(){
        return this.defensa;
    }
    public int setDefensa(int defensa){
        return this.defensa=defensa;
    }
    public int getAtaqueSpecial(){
        return this.ataqueSpecial;
    }
    public int setAtaqueSpecial (int ataqueSpecial){
        return this.ataqueSpecial=ataqueSpecial;
    }
    public int getDefensaSpecial(){
        return this.defensaSpecial;
    }
    public int setDefensaSpecial (int defensaSpecial){
        return this.defensaSpecial=defensaSpecial;
    }
    public int getVelocidad(){
        return this.velocidad;
    }
    public int setVelocidad (int velocidad){
        return this.velocidad=velocidad;
    }

    //Devuelve true si el personaje que lo invoca es más Rápido que el objetivo
    public boolean compararVelocidad(Personaje personaje){
        boolean masRapido=false;
        if (this.velocidad>personaje.getVelocidad()){
            masRapido=true;
        }
        return masRapido;
    }

    public int muerte(int ataqueRealizado){
        int ataque=ataqueRealizado;
        if (this.vida==0){
            ataque=ataqueRealizado-this.defensaSpecial;
        }
        return ataque;
    }

    public int ataque(Personaje personaje){
        int ataqueRealizado=this.ataque - personaje.getDefensa();
        ataqueRealizado=muerte(ataqueRealizado);
        if (ataqueRealizado<=0){ //para evitar números negativos y que los ataques no sumen vida
            ataqueRealizado=0;
        }
        return personaje.getVida()-ataqueRealizado;
    }

    public void ataqueSpecial(Personaje personaje){
        if (ataqueDisponible==0){
            System.out.println("Has gastado ya tus ataques especiales");
        }else{
            int ataqueRealizado=(this.ataqueSpecial+this.ataque) - (personaje.getDefensa());
            ataqueRealizado=muerte(ataqueRealizado);
            if (ataqueRealizado<=0){ //para evitar números negativos y que los ataques no sumen vida
            ataqueRealizado=0;
            }
            personaje.setVida(personaje.getVida()-ataqueRealizado);
        }
        
    }


}
