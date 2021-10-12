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
		
	while (true) { //Loop até que o usuário insira um número válido para os rounds
		System.out.println("Insira um valor inteiro para a quantidade de rounds desejados");
		rounds = scanner.nextInt();
		if(rounds > 0) {
			break;
		}
		System.out.println(rounds + " não é válido, tente novamente");
	}

	for(int i = 0; i < rounds; i++) { //Loop de rounds, com iniciação de rounds e ações dos jogadores
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
          System.out.println("=--=-=-=-=-=-=-=-=PONTUAÇÕES-=-=-=-=-=-=-=-=-=-");
    	  System.out.println(player1.name + ": " + player1.score + "  " + player2.name + ": " 
    			             + player2.score + "  " + player3.name + ": " + player3.score);
	  }	
}
}


