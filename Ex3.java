import java.time.*;

public class Ex3 {
    public static void main(String[] args) throws InterruptedException {

        while (true) {
            LocalDateTime now = LocalDateTime.now();

            LocalDateTime lastMoment = LocalDateTime
                    .of(now.getYear() + 1, 1, 1, 0, 0)
                    .minusSeconds(1);

            Duration diff = Duration.between(now, lastMoment);

            long totalSeconds = diff.getSeconds();

            long days = totalSeconds / (24 * 3600);
            long hours = (totalSeconds % (24 * 3600)) / 3600;
            long minutes = (totalSeconds % 3600) / 60;
            long seconds = totalSeconds % 60;

            System.out.print("\rFaltam " + days + " dias, "
                    + hours + " horas, "
                    + minutes + " minutos e "
                    + seconds + " segundos para o fim do ano.");

            Thread.sleep(1000); // atualiza a cada 1 segundo
        }
    }
}