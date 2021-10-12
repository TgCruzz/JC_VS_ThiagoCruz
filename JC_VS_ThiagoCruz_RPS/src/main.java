import java.util.Scanner;

public class main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
int rounds;

player player1 = new player("Jogador 1");
player player2 = new player("Jogador 2");
player player3 = new player("Jogador 3");	
player[] players = {player1, player2, player3};

Scanner scanner = new Scanner(System.in);
		
	while (true) { //Loop at� que o usu�rio insira um n�mero v�lido para os rounds
		System.out.println("Insira um valor inteiro para a quantidade de rounds desejados");
		rounds = scanner.nextInt();
		if(rounds > 0) {
			break;
		}
		System.out.println(rounds + " n�o � v�lido, tente novamente");
	}

	for(int i = 0; i < rounds; i++) { //Loop de rounds, com inicia��o de rounds e a��es dos jogadores
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		
         for(player p : players) {
    	     p.newThread();
          }
          players[0].thread.join();
          players[1].thread.join();
          players[2].thread.join();
          
          for(player p : players) {
     	     p.play();
           }
          
          player1.check(player2, player3);  //Checagem das jogadas e print dos pontos  
          System.out.println("=--=-=-=-=-=-=-=-=PONTUA��ES-=-=-=-=-=-=-=-=-=-");
    	  System.out.println(player1.name + ": " + player1.score + "  " + player2.name + ": " 
    			             + player2.score + "  " + player3.name + ": " + player3.score);
	  }	
}
}


