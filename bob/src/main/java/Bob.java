public class Bob {

    private enum Response {
        SURE("Sure."),
        WHOA("Whoa, chill out!"),
        FINE("Fine. Be that way!"),
        WHATEVER("Whatever.");

        private final String textResponse;

        Response(String textResponse) {
            this.textResponse = textResponse;
        }

        public String getTextResponse() {
            return textResponse;
        }

        public static Response getResponse(String msg) {

            if (msg.trim().equals("")) return FINE;

            String normalizedMsg = msg.replaceAll("\\P{L}+","");
            boolean isYelling = !normalizedMsg.equals("") && normalizedMsg.chars()
                    .mapToObj(i -> (char)i)
                    .allMatch(Character::isUpperCase);
            if (isYelling) return WHOA;

            if (msg.endsWith("?")) return SURE;

            return WHATEVER;
        }
    }

    public String hey(String msg) {
        Response response = Response.getResponse(msg);
        return response.getTextResponse();
    }
}
