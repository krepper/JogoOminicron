package mecanica;

/**
 *
 * @author felipesobral
 */

public class Itens {
    int st1;
    int st2;
    private Status status;
    private Itens itens;
    
    
    // NÚMERO DO DADO, SE NÚMERO DO DADO == ITEM, ELA GANHA OS ATRIBUTOS
    public void set1(int numDado){
        
        // SET1
            // CAPACETE
            if (numDado==1){
                itens.mochila(1);
                st1 = st1+1;
                
            }
            // PEITORAL
            if (numDado==2){
                itens.mochila(2);
                st1 = st1+1;
            }
            // BOTAS
            if (numDado==3){
                itens.mochila(3);
                st1 = st1+1;
            }
            // ESPADA
            if (numDado==4){
                itens.mochila(4);
                st1 = st1+1;
            }
            
        // ITEM ESPECIAL (amuleto)
            if (numDado==5){
                status.atri(500, 500, 500);
                System.out.println("Paranbéns, você ganhou um item especial!! (amuleto)");
                itens.mochila(5);
            }
            
        // SET2
            // CAPACETE
            if (numDado==6){
                itens.mochila(6);
                st2 = st2+1;
            }
            // PEITORAL
            if (numDado==7){
                itens.mochila(7);
                st2 = st2+1;
            }
            // BOTAS
            if (numDado==8){
                itens.mochila(8);
                st2 = st2+1;
            }
            // ESPADA
            if (numDado==9){
                itens.mochila(9);
                st2 = st2+1;
            }

    }
    
    private void mochila (int codigoItem){
        
        if (st1 < 6){
        // SET1
            // CAPACETE
            if (codigoItem==1){
                status.atri(0, 0, 100); //status.atri(INTELIGÊNCIA, FORÇA, VIDA);
                System.out.println("Parabéns, você ganhou o capacete de madeira");
                
            }
            // PEITORAL
            if (codigoItem==2){
                status.atri(0, 0, 500);
                System.out.println("Parabéns, você ganhou o peitoral de madeira");
            }
            // BOTAS
            if (codigoItem==3){
                status.atri(0, 0, 100);
                System.out.println("Parabéns, você ganhou as botas de madeira");
            }
            // ESPADA
            if (codigoItem==4){
                status.atri(50, 100, 0);
                System.out.println("Parabéns, você ganhou a espada de madeira");
            }
        } else {
            System.out.println("Você não pode mais ganhar itens de madeira!");
        }
        
        if (st2 < 6){
            // SET2
            // CAPACETE
            if (codigoItem==6){
                status.atri(0, 0, 300); //status.atri(INTELIGÊNCIA, FORÇA, VIDA);
                System.out.println("Parabéns, você ganhou o capacete de cobre");
            }
            // PEITORAL
            if (codigoItem==7){
                status.atri(0, 0, 1000);
                System.out.println("Parabéns, você ganhou o peitoral de cobre");
            }
            // BOTAS
            if (codigoItem==8){
                status.atri(0, 0, 150);
                System.out.println("Parabéns, você ganhou as botas de cobre");
            }
            // ESPADA
            if (codigoItem==9){
                status.atri(100, 350, 0);
                System.out.println("Parabéns, você ganhou a espada de cobre");
            } else {
                System.out.println("Você não pode ganhar mais itens de cobre!!");
            }
        }
    }

    
}
