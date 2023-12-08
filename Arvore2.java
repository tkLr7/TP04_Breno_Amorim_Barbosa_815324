import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arvore2 {

    private static int comp = 0;

    public static class No2{
        public No2 esq;
        public No2 dir;
        public String nome;
     
        public No2(String nome)throws Exception{
           this.esq = null;
           this.dir = null;
           this.nome = nome;
        }
     
        public No2(String nome, No2 esq, No2 dir)throws Exception{
             this.nome = nome;
             this.esq = esq;
             this.dir = dir;
         }
     }
     
      public static class No{
        public No esq;
        public No dir;
        public int altura;
        public No2 raiz;
     
        public No(int altura)throws Exception{
           this.esq = null;
           this.dir = null;
           this.altura = altura;
           this.raiz = null;
        }
        
        public No(int altura, No esq, No dir)throws Exception{
            this.altura = altura;
            this.esq = esq;
            this.dir = dir;
            this.raiz = null;
         }
     
        public void Inserir(String p)throws Exception{
           raiz = Inserir(raiz, p);
        }
     
        public No2 Inserir(No2 i, String p)throws Exception{
           if(i == null)
              i = new No2(p);
           else{
              if(p.compareTo(i.nome) < 0 ){
                 comp++;
                 i.esq = Inserir(i.esq, p);
              }else{
                 if(p.compareTo(i.nome) > 0 ){
                    comp++;
                    i.dir = Inserir(i.dir, p);
                 }
              }
           }
           return i;
        }
     
        public boolean pesqPre(String nome) {
           
            return pesqPre(raiz, nome);
         }
     
         private boolean pesqPre(No2 i, String nome) {
           boolean resp = false;
             if (i != null) {
                 resp = (i.nome.compareTo(nome) == 0);
              if(!resp){
                 comp++;
                 MyIO.print("ESQ ");
                    resp = pesqPre(i.esq, nome); 
              }
              if(!resp){
                 comp++;
                 MyIO.print("DIR ");
                    resp = pesqPre(i.dir, nome); 
              }
           }
           return resp;
         }
        public int getcomp(){
           return comp;
        }
     }
     
     
     
      public static class AvrAvr{
        private No raiz;
     
        public AvrAvr(){
           this.raiz = null;
        }
     
        public void inserir1(int p)throws Exception{
           raiz = inserir1(raiz, p);
        }
     
        public No inserir1 (No i, int p)throws Exception{
           if(i == null)
              i = new No(p);
           else{
              if(p < i.altura ){
                 comp++;
                 i.esq = inserir1(i.esq, p);
              }else{
                 if(p > i.altura ){
                    comp++;
                    i.dir = inserir1(i.dir, p);
                 }
              }
           }
           return i;
        }
     
        public void inserir2(Player p)throws Exception{
           inserir2(raiz, p.getNome(), (p.getAltura()%15));
        } 
     
        public void inserir2 (No i, String nome, int num )throws Exception{
           if(num < i.altura ){
              comp++;
              inserir2(i.esq, nome, num);
           }else{
              if(num > i.altura ){
                 comp++;
                 inserir2(i.dir, nome, num);
              }else{
                 i.Inserir(nome);
              }
           }
        }
     
        public boolean pesqPre(String nome) {
           MyIO.print(""+nome+" raiz ");
             return pesqPre(raiz, nome);
         }
     
     
         private boolean pesqPre (No i, String nome) {
           boolean resp = false;
             if (i != null) {
                 resp = i.pesqPre(nome);
              if(!resp){
                 comp++;
                 MyIO.print("esq ");
                    resp = pesqPre(i.esq, nome); 
              }
              if(!resp){
                 comp++;
                 MyIO.print("dir ");
                    resp = pesqPre(i.dir, nome); 
              }
           }
           return resp;
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
    AvrAvr arvore = new AvrAvr();

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
    
    arvore.inserir1(7);
    arvore.inserir1(3);
    arvore.inserir1(11);
    arvore.inserir1(1);
    arvore.inserir1(5);
    arvore.inserir1(9);
    arvore.inserir1(13);
    arvore.inserir1(0);
    arvore.inserir1(2);
    arvore.inserir1(4);
    arvore.inserir1(6);
    arvore.inserir1(8);
    arvore.inserir1(10);
    arvore.inserir1(12);
    arvore.inserir1(14);
    
    String id = MyIO.readLine();
    while (!id.equals("FIM"))
    {
        for (int i = 0; i < jogador.length; i++) 
        {
            if (jogador[i] != null && jogador[i].getId() == Integer.parseInt(id)) 
            {
                arvore.inserir2(jogador[i]);
            }
        }
        id = MyIO.readLine();
    }
    String nome = MyIO.readLine();
    while (!nome.equals("FIM"))
    {
        boolean achar = arvore.pesqPre(nome);
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
    Arq.openWriteClose("815324_arvoreArvore.txt", arquivar);
}
}
