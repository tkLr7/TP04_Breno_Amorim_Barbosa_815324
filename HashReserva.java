import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HashReserva {
    private static int comp = 0;
public static class Hash {
        String tabela[];
        int m1, m2, m, reserva;
        final int NULO = -1;
     
        public Hash() {
           this(21, 9);
        }
     
        public Hash(int m1, int m2) {
            this.m1 = m1;
            this.m2 = m2;
            this.m = m1 + m2;
            this.tabela = new String[this.m];
            for (int i = 0; i < m1; i++) {
                comp++;
                tabela[i] = null;
            }
           reserva = 0;
        }
     
        public int hash(int pos) {
           return pos % m1;
        }
     
        public void inserir(String nome, int pos) {
            comp++;
            if (nome != null) 
            {
                int find = hash(pos);
                comp++;
                if (tabela[find] == null) 
                {
                    tabela[find] = nome;
                }
                else if (reserva < m2) 
                {
                    comp++;
                    tabela[m1 + reserva] = nome;
                    reserva++;
                }
            }
        }
     
        public boolean pesquisar(String nome, int pos) {
            boolean resp = false;
            int find = hash(pos);
            comp++;
        
            // Add a null check before invoking the equals method
            comp++;
            if (tabela[find] != null && tabela[find].equals(nome)) {
                resp = true;
            } else if (tabela[find] == null) {
                comp++;
                resp = false;
            } else if (resp) {
                comp++;
                for (int i = 0; i < reserva; i++) {
                    comp++;
                    comp++;
                    if (tabela[m1 + i] != null && tabela[m1 + i].equals(nome)) {
                        resp = true;
                        i = reserva;
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
            } 
            else
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
    Hash tabela = new Hash();

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
            tabela.inserir(jogador[i].getNome(), jogador[i].getAltura());
        }
        }
        id = MyIO.readLine();
    }
    
    String nome = MyIO.readLine(); 

    while (!nome.equals("FIM"))
    {
        int avanca = 0;
        int altura = 0;
        while (avanca < 3922) 
        {
            if (jogador[avanca].getNome().equals(nome))
            {
                altura = jogador[avanca].getAltura();
            }
            avanca++;
        }
        MyIO.print(nome+" "); 
        boolean achar = tabela.pesquisar(nome, altura);
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
    Arq.openWriteClose("815324_hashReserva.txt", arquivar);
}


}
