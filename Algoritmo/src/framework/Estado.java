package framework;

public class Estado extends EventoThread {
    
    public Entidade ent;
    public Estado(int idEmissor, int idDestino) {
        super(idEmissor, idDestino);
    }
    public void transicao(Evento _e){
       // Esse metodo deve ser especializado
    }
    // Ação executada na entrada do estado
    public void acao(){
            // Deve ser sobrescrita
    }

    
}
