package tagcount;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchTag {
    public String countTag(String line) 
    {   
        Matcher match;
        match = Pattern.compile("<[a-zA-Z]+").matcher(line);
        while (match.find()) {
            return match.group();
        }
        return null;
    }        
}
