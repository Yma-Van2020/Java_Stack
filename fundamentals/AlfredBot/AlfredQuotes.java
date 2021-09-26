import java.util.Date;
public class AlfredQuotes {
    public String basicGreeting(){
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name){
        return String.format("Hi %s, nice to meet you. How are you today", name);
    }

    public String dateAnnouncement() {
        Date date = new Date();
        return "Today is " + date;
    }

    public String respondBeforeAlexis(String converstation){
        if(converstation.indexOf("Alexis") >= 1){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if (converstation.indexOf("Alfred") >= 1){
            return "At your service. As you wish, naturally.";
        } else {
            return "Right. And with that I shall retire." ;
        }
    }
}