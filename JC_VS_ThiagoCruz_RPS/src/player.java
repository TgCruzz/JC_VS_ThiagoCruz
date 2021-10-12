import java.util.Random;

public class player {

	String name;
	String[] hand = {"rock", "paper", "scissors"};
	String move;
	int score;
	playerThread thread;
	
	
	
	public class playerThread extends Thread { //Classe usada para criação de threads a serem utilizadas pelos jogadores
		
		String[] hand;
		String play;
		
		public void run() {
			play = play(hand);
		}
		
		public String play (String[] hand) {
			
			return hand[new Random().nextInt(hand.length)];
		}
		
	}
	
	
	public player(String _name) { //Construtor do jogador
		this.name = _name;
	}
	
	public void newThread () {  //Função que instancia a classe de criação de Threads por player
		thread = new playerThread();
		thread.hand = hand;
		thread.start();	
	}
	
	public void play() {  //Armazena o valor das jogadas feitas em cada thread para comparação
		this.move = thread.play;
	     System.out.println(this.name + " - " + this.move); 
	}
	
	public void check(player opponent1, player opponent2) { //Comparação de jogadas para atribuir resultados e pontos
		//CHECAGEM EMPATE
		if (this.move.equals(opponent1.move) && this.move.equals(opponent2.move)) {
			System.out.println("Todos os jogadores empataram!");
		}
		//CHECAGEM PEDRA
		else if (this.move.equals("rock")) {
			if(opponent1.move.equals("scissors") && opponent2.move.equals("paper")) {
				System.out.println("Todos os jogadores se derrotaram!");
			}
			if(opponent1.move.equals("paper") && opponent2.move.equals("scissors")) {
				System.out.println("Todos os jogadores se derrotaram!");
			}
			if(opponent1.move.equals("paper") && opponent2.move.equals("rock")) {
				System.out.println(opponent1.name + " derrotou " + this.name + " e " + opponent2.name + "!");
				opponent1.score += 2;
			}
			if(opponent1.move.equals("scissors") && opponent2.move.equals("rock")) {
				System.out.println(opponent1.name + " foi derrotado por " + this.name + " e " + opponent2.name + "!");
				this.score += 1;
				opponent2.score += 1;
			}
			if(opponent1.move.equals("rock") && opponent2.move.equals("paper")) {
				System.out.println(opponent2.name + " derrotou " + this.name + " e " + opponent1.name + "!");
				opponent2.score += 2;
			}
			if(opponent1.move.equals("rock") && opponent2.move.equals("scissors")) {
				System.out.println(opponent2.name + " foi derrotado por " + this.name + " e " + opponent1.name + "!");
				this.score += 1;
				opponent1.score += 1;
			}
			if(opponent1.move.equals("paper") && opponent2.move.equals("paper")) {
				System.out.println(this.name + " foi derrotado por " + opponent1.name + " e " + opponent2.name + "!");
				opponent2.score += 1;
				opponent1.score += 1;
			}
			if(opponent1.move.equals("scissors") && opponent2.move.equals("scissors")) {
				System.out.println(this.name + " derrotou " + opponent1.name + " e " + opponent2.name + "!");
				this.score += 2;
			}
		}
		//CHECAGEM PAPEL
		else if (this.move.equals("paper")) {
			if(opponent1.move.equals("scissors") && opponent2.move.equals("rock")) {
				System.out.println("Todos os jogadores se derrotaram!");
			}
			if(opponent1.move.equals("rock") && opponent2.move.equals("scissors")) {
				System.out.println("Todos os jogadores se derrotaram!");
			}
			if(opponent1.move.equals("scissors") && opponent2.move.equals("paper")) {
				System.out.println(opponent1.name + " derrotou " + this.name + " e " + opponent2.name + "!");
				opponent1.score += 2;
			}
			if(opponent1.move.equals("rock") && opponent2.move.equals("paper")) {
				System.out.println(opponent1.name + " foi derrotado por " + this.name + " e " + opponent2.name + "!");
				this.score += 1;
				opponent2.score += 1;
			}
			if(opponent1.move.equals("paper") && opponent2.move.equals("scissors")) {
				System.out.println(opponent2.name + " derrotou " + this.name + " e " + opponent1.name + "!");
				opponent2.score += 2;
			}
			if(opponent1.move.equals("paper") && opponent2.move.equals("rock")) {
				System.out.println(opponent2.name + " foi derrotado por " + this.name + " e " + opponent1.name + "!");
				this.score += 1;
				opponent1.score += 1;
			}
			if(opponent1.move.equals("scissors") && opponent2.move.equals("scissors")) {
				System.out.println(this.name + " foi derrotado por " + opponent1.name + " e " + opponent2.name + "!");
				opponent1.score += 1;
				opponent2.score += 1;
			}
			if(opponent1.move.equals("rock") && opponent2.move.equals("rock")) {
				System.out.println(this.name + " derrotou " + opponent1.name + " e " + opponent2.name + "!");
				this.score += 2;
			}
		}
			//CHECAGEM TESOURA
		else if (this.move.equals("scissors")) {
			if(opponent1.move.equals("paper") && opponent2.move.equals("rock")) {
				System.out.println("Todos os jogadores se derrotaram!");
			}
			if(opponent1.move.equals("rock") && opponent2.move.equals("paper")) {
				System.out.println("Todos os jogadores se derrotaram!");
			}
			if(opponent1.move.equals("rock") && opponent2.move.equals("scissors")) {
				System.out.println(opponent1.name + " derrotou " + this.name + " e " + opponent2.name + "!");
				opponent1.score += 2;
			}
			if(opponent1.move.equals("paper") && opponent2.move.equals("scissors")) {
				System.out.println(opponent1.name + " foi derrotado por " + this.name + " e " + opponent2.name + "!");
				this.score += 1;
				opponent2.score += 1;
			}
			if(opponent1.move.equals("scissors") && opponent2.move.equals("rock")) {
				System.out.println(opponent2.name + " derrotou " + this.name + " e " + opponent1.name + "!");
				opponent2.score += 2;
			}
			if(opponent1.move.equals("scissors") && opponent2.move.equals("paper")) {
				System.out.println(opponent2.name + " foi derrotado por " + this.name + " e " + opponent1.name + "!");
				this.score += 1;
				opponent1.score += 1;
			}
			if(opponent1.move.equals("rock") && opponent2.move.equals("rock")) {
				System.out.println(this.name + " foi derrotado por " + opponent1.name + " e " + opponent2.name + "!");
				opponent1.score += 1;
				opponent2.score += 1;
			}
			if(opponent1.move.equals("paper") && opponent2.move.equals("paper")) {
				System.out.println(this.name + " derrotou " + opponent1.name + " e " + opponent2.name + "!");
				this.score += 2;
			}
		}		
	}
}

