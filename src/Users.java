public class Users {
    private String nome;
    private int idade;
    private static int contaUsers;

    public Users()
    {
        this.nome="";
        this.idade=0;
        contaUsers++;
    }

    public Users(String nome,int idade)
    {
        this.nome=nome;
        this.idade=idade;
        contaUsers++;
    }

    public Users(String nome)
    {
        this.nome="";
        this.idade=0;
        contaUsers++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getIdade()
    {
        return idade;
    }

    public void setIdade(int idade)
    {
        this.idade = idade;
    }

    public String toString()
    {
        String output="";
        output="Nome: " + nome + "\n";
        output="Idade: " + idade  ;
        return output;
    }

    public boolean equals(Object obj)
    {
        //condição se é o próprio
        if(this==obj) return true;

        //condição se é nulo
        if (obj==null) return false;

        //condição se são objetos de classe distintas
        if(this.getClass()!=obj.getClass()) return false;

        //condição caso contrário
        Users user1  = (Users)obj;
        return idade == user1.getIdade();
    }

    /*
        set é uma interface que extende da coleção de forma não ordenada,
        é usado para que os valores duplicados não sejam guardados
         */
    public static int getContaUsers()
    {
        return contaUsers;
    }


}
