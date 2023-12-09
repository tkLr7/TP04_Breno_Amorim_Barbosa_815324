import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class arvoreTrie {
       private static int comp = 0;

public static class No {
    public char elemento;
    public final int tamanho = 255;
    public No[] prox;
    public boolean folha;
    
    public No (){
       this(' ');
    }
 
    public No (char elemento){
       this.elemento = elemento;
       prox = new No [tamanho];
       for (int i = 0; i < tamanho; i++) prox[i] = null;
       folha = false;
    }
 
    public static int hash (char x){
       return (int)x;
    }
}
public static class Binaria{
    private No raiz;

    public Binaria(){
        raiz = new No();
    }


    public boolean pesquisar(String s) throws Exception {
        return pesquisar(s, raiz, 0);
    }

    public boolean pesquisar(String s, No no, int i) throws Exception {
        boolean resp;
        comp++;
        if(no.prox[s.charAt(i)] == null){
  
           resp = false;
        }
        else
        {
            comp++;
            if(s.length()-1 == i)
            {
                resp = (no.prox[s.charAt(i)].folha == true);
            }
            else
            {
                comp++;
                if(i < s.length()-1)
                {
                    resp = pesquisar(s, no.prox[s.charAt(i)], i+1);
                }
                else
                    throw new Exception("ERRO AO PESQUISAR");
            }
        }   
        return resp;
    }

    public void inserir(String s) throws Exception {
        inserir(s, raiz, 0);
    }

    private void inserir(String s, No no, int i) throws Exception {

        if(no.prox[s.charAt(i)] == null){

            no.prox[s.charAt(i)] = new No(s.charAt(i));

            if(i == s.length() - 1){

                no.prox[s.charAt(i)].folha = true;
            }else{
                inserir(s, no.prox[s.charAt(i)], i + 1);
            }

        } else if (no.prox[s.charAt(i)].folha == false && i < s.length() - 1){
            inserir(s, no.prox[s.charAt(i)], i + 1);

        } else {
            throw new Exception("Erro ao inserir!");
        } 
    }

    public void mostrar(){
        mostrar("", raiz);
    }

    public void mostrar(String s, No no) {
        if(no.folha == true){
            System.out.println("Palavra: " + (s + no.elemento));
        } else {
            for(int i = 0; i < no.prox.length; i++){
                if(no.prox[i] != null){
                    System.out.println("ESTOU EM (" + no.elemento + ") E VOU PARA (" + no.prox[i].elemento + ")");
                    mostrar(s + no.elemento, no.prox[i]);
                }
            }
        }
    }

    public Binaria merge(Binaria arvore)throws Exception{
        Binaria arvore3 = new Binaria();
        arvore3.merge("", this.raiz);
        arvore3.merge("", arvore.raiz);
        return arvore3;
    }
  
     private void merge( String p, No i)throws Exception{
        comp++;
        if(i.folha == true){
           this.inserir(p);
        }else{
           for(int j = 0; j < 255; j++){
              comp++;
              if(i.prox[j] != null){
                 merge( p+i.prox[j].elemento, i.prox[j]);
              }
           }
        }
    }

    public int contarAs(){
        int resp = 0;
        if(raiz != null){
            resp = contarAs(raiz);
        }
        return resp;
    }

    public int contarAs(No no) {
        int resp = (no.elemento == 'A') ? 1 : 0;

        if(no.folha == false){
            for(int i = 0; i < no.prox.length; i++){
                if(no.prox[i] != null){
                    resp += contarAs(no.prox[i]);
                }
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
    Binaria arvore = new Binaria();
    Binaria arvore2 = new Binaria();


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
                MyIO.println(id+"\t"+ jogador[i].getNome());
                arvore.inserir(jogador[i].getNome());
            }
        }
        id = MyIO.readLine();
    }

    String id2 = MyIO.readLine();
    while (!id2.equals("FIM"))
    {
        for (int i = 0; i < jogador.length; i++) 
        {
            if (jogador[i] != null && jogador[i].getId() == Integer.parseInt(id2)) 
            {
                MyIO.println(id2+"\t"+ jogador[i].getNome());
                arvore2.inserir(jogador[i].getNome());
            }
        }
        id2 = MyIO.readLine();
    }

    Binaria arvore3 = arvore.merge(arvore2);

    String nome = MyIO.readLine();
    while (!nome.equals("FIM"))
    {
        boolean achar = arvore3.pesquisar(nome);
        MyIO.print(nome+" ");
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
    Arq.openWriteClose("815324_arvoreTrie.txt", arquivar);
}

}
