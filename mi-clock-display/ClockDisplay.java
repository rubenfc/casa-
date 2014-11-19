public class ClockDisplay
{
    // The hours.
    private NumberDisplay hour;
    // The minutes.
    private NumberDisplay minute;
    // The current time.
    private String currentTime;
    
    
    /**
     * Initialize the clock to 00:00
     */
    public ClockDisplay()
    {
        hour = new NumberDisplay(24);
        minute = new NumberDisplay(60);
        updateDisplay();
    }
    
    /**
     * Initialize the clock to the given time.
     */
    public ClockDisplay(int newHour, int newMinute)
    {
       hour = new NumberDisplay(24);
       minute = new NumberDisplay(60);
       hour.setValue(newHour);
       minute.setValue(newMinute);
       
       updateDisplay();
    }
    
    /**
     * Sets the clock to the given hour and minute.
     */
    public void setTime(int newHour, int newMinute)
    {
       hour.setValue(newHour);
       minute.setValue(newMinute);
       updateDisplay();
    }
    
    /**
     * Returns the Time in 24h format.
     */
    public String getTime()
    {
        return currentTime;
    }
    
    /**
     * Sets the time 1 minute forward.
     */
    public void timeTick()
    {
        minute.increment();
        if (minute.getDisplayValue().equals("00"))
        {
            hour.increment();
        }
        updateDisplay();
    } 
    
    /**
     * Updates the current time.
     */
    private void updateDisplay()
    {   
        int newHora = hour.getValue();
        int horaTarde = hour.getValue() -12;
        if (newHora < 12)
        {
        currentTime = hour.getDisplayValue() + ":" +  minute.getDisplayValue() + " a.m";
        }
        else if (newHora == 12)
        {
            currentTime = hour.getDisplayValue() + ":" +  minute.getDisplayValue() + " p.m";
        }
        else 
        {
        currentTime = horaTarde + ":" +  minute.getDisplayValue() + " p.m";
        }
    }     
}