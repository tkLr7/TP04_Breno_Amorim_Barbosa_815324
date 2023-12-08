import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class ArvoreBi {
       private static int comp = 0;
public static class No {
        public Player elemento;
        public No esq, dir;
    
        public No(Player elemento) {
            this(elemento, null, null);
        }
    
        public No(Player elemento, No esq, No dir) {
            this.elemento = elemento;
            this.esq = esq;
            this.dir = dir;
        }
    }
public static class Binaria{
   private No raiz;

   public Binaria(){
      this.raiz = null;
   }

   public void insert(Player p)throws Exception{
      raiz = insert(raiz, p);
   }

   public No insert(No i, Player p)throws Exception{
      if(i == null)
         i = new No(p);
      else{
         if(p.getNome().compareTo(i.elemento.getNome()) < 0 ){
            comp++;
            i.esq = insert(i.esq, p);
         }else{
            if(p.getNome().compareTo(i.elemento.getNome()) > 0 ){
               comp++;
               i.dir = insert(i.dir, p);
            }
         }
      }
      return i;
   }

   public void remove(String nome)throws Exception{
      raiz = remove(raiz, nome);
   }

   public No remove(No i, String nome)throws Exception{
      if(i == null)
         throw new Exception("ERRO!");
      else{
         if(nome.compareTo(i.elemento.getNome()) < 0){
            i.esq = remove(i.esq, nome);
            comp++;
         }else{
            if(nome.compareTo(i.elemento.getNome()) > 0){
               i.dir = remove(i.dir, nome);
               comp++;
            }else{
               if(i.dir == null){
                  i = i.esq;
               }else{
                  if(i.esq == null){
                     i = i.dir;
                  }else{
                     i.esq = anterior(i, i.esq);
                  }
               }
            }
         }
      }
      return i;
   }

   public No anterior(No i, No j){
      if(j.dir != null){
         j.dir = anterior(i, j.dir);
      }else{
         i.elemento = j.elemento;
         j = j.esq;
      }
      return j; 
   }

   public boolean search(String nome){
      MyIO.print(""+nome+" raiz ");
      return search(raiz, nome);
   }

   public boolean search(No i, String nome){
      boolean resp;
      if(i == null)
         resp = false;
      else{
         if(nome.compareTo(i.elemento.getNome()) < 0 ){
            comp++;
            MyIO.print("esq ");
            resp = search(i.esq, nome);
         }else{
            if(nome.compareTo(i.elemento.getNome()) > 0 ){
               comp++;
               MyIO.print("dir ");
               resp = search(i.dir, nome);
            }else{
               resp = true;
            }
         }
      }
      return resp;
   }

   public void showCent(){
      showCent(raiz);
   }

   public void showCent(No i){
      if(i != null){
         showCent(i.esq);
         i.elemento.imprimir();
         showCent(i.dir);
      }
   }

   public void showPre() {
      showPre(raiz);
   }


   private void showPre(No i) {
      if (i != null) {
         i.elemento.imprimir(); 
         showPre(i.esq); 
         showPre(i.dir); 
      }
   }

   public int getcomp(){
      return comp;
   }
}
public static class Player {
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    static List<Player> players = new ArrayList<>();

    Player()
    {
        this.id = -1;
        this.altura = -1;
        this.peso = -1;
        this.anoNascimento = -1;
        this.nome = null;
        this.universidade = null;
        this.cidadeNascimento = null;
        this.estadoNascimento = null;
    }
    Player (int id, String nome, int altura, int peso, String univerdade, int anoNascimento, String cidadeNascimento, String estadoNascimento)
    {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = univerdade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    
    public int getId() 
    {
        return id;
    }
    
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    
    public String getNome() 
    {
        return nome;
    }
    
    public void setAltura(int altura) 
    {
        this.altura = altura;
    }
    
    public int getAltura() 
    {
        return altura;
    }
    
    public void setPeso(int peso)
     {
        this.peso = peso;
    }
    
    public int getPeso() 
    {
        return peso;
    }
    
    public void setUniversidade(String universidade) 
    {
        this.universidade = universidade;
    }
    
    public String getUniversidade() 
    {
        return universidade;
    }
    
    public void setAno(int ano) 
    {
        this.anoNascimento = ano;
    }
    
    public int getAno() 
    {
        return anoNascimento;
    }

    public void setCidade(String cidade) 
    {
        this.cidadeNascimento = cidade;
    }

    public String getCidade() 
    {
        return cidadeNascimento;
    }

    public void setEstado(String estado) 
    {
        this.estadoNascimento = estado;
    }

    public String getEstado() 
    {
        return estadoNascimento;
    }
    
    @Override
    protected Player clone() throws CloneNotSupportedException
    {
        return (Player) super.clone();
    }

    public void ler(String linha){              
        int indexVirgulas[] = new int[7];
        int contVirgulas = 0;
        for(int i=0; i<linha.length(); i++)
        {
            comp++;
            comp++;
            if(linha.charAt(i)==','){
                indexVirgulas[contVirgulas]=i;
                contVirgulas++;
            }
        }
            id = Integer.parseInt(linha.substring(0, indexVirgulas[0]));
            nome = linha.substring(indexVirgulas[0]+1, indexVirgulas[1]);
            altura = Integer.parseInt(linha.substring(indexVirgulas[1]+1, indexVirgulas[2]));
            peso = Integer.parseInt(linha.substring(indexVirgulas[2]+1, indexVirgulas[3]));
        comp++;
        if((indexVirgulas[4]-indexVirgulas[3]+1) == 2)
        {
            universidade = "nao informado";
        } else
        {
            universidade = linha.substring(indexVirgulas[3]+1, indexVirgulas[4]);
        }
        
            anoNascimento = Integer.parseInt(linha.substring(indexVirgulas[4]+1, indexVirgulas[5])); 
        comp++;
        if(indexVirgulas[6]-indexVirgulas[5]+1 == 2)
        {
           cidadeNascimento = "nao informado";
        } else
        {
            cidadeNascimento = linha.substring(indexVirgulas[5]+1, indexVirgulas[6]);
        }
        comp++;
        if(linha.length()-indexVirgulas[6]+1 == 2)
        {
            estadoNascimento = "nao informado";
        } else
        {
            estadoNascimento = linha.substring(indexVirgulas[6]+1, linha.length());
        }
    }
    public void imprimir()
    {
        MyIO.print(""+id+" ## "+nome+" ## "+altura+" ## "+peso+" ## "+anoNascimento+" ## "+universidade+" ## "+cidadeNascimento+" ## "+estadoNascimento+" ##\n");
    }
}

public static void main (String[] args) throws IOException, Exception
{
    double inicio, fim;
    Player[] jogador = new Player[3923];
    Binaria arvore = new Binaria();

    inicio = System.currentTimeMillis();

    Arq.openRead("/tmp/players.csv");

    String info = "";
    Arq.readLine();
    int pos = 0; 
    while (Arq.hasNext() && pos <= 3921) 
    {
        comp++;
        info = Arq.readLine();
        jogador[pos] = new Player(); 
        jogador[pos].ler(info); 
        pos++;
    }
    comp++;
    if (pos == 3921) 
    {  
        pos++;
        jogador[pos] = new Player(); 
        jogador[pos].ler(info); 
    }
    Arq.close();

    
    String id = MyIO.readLine();
    while (!id.equals("FIM"))
    {
        for (int i = 0; i < jogador.length; i++) 
        {
            if (jogador[i] != null && jogador[i].getId() == Integer.parseInt(id)) 
            {
                arvore.insert(jogador[i]);
            }
        }
        id = MyIO.readLine();
    }
    String nome = MyIO.readLine();
    while (!nome.equals("FIM"))
    {
        boolean achar = arvore.search(nome);
        if (achar) 
        {
            MyIO.println("SIM");    
        }
        else
        {
            MyIO.println("NAO"); 
        }
        nome = MyIO.readLine();
    }
    fim = System.currentTimeMillis();

    String tempo = (fim - inicio)/1000 + "\t";
    String arquivar = "815324\t" + tempo + comp;
    Arq.openWriteClose("815324_arvoreBinaria.txt", arquivar);
}
}