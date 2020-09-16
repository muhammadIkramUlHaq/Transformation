import spoon.Launcher;

public class TaskRunner {
        public static void main(String[] args) {
            final String[] configuration = {
                    "-i", "src/main/resources/src/",
                    "-o", "target/transformed/",
                    "-p", "FlagRemovalProcessor",
                    "--compile"
            };

            final Launcher launcher = new Launcher();
            launcher.setArgs(configuration);
            launcher.run();
        }
}
