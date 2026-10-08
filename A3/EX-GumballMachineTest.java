/*
1. Write a Java Program to implement State Pattern for Gumball Machine. Create an
instance variable that holds the current state from there, we just need to handle all
actions, behaviors and state transitions that can happen. For actions we need to
implement methods to insert a quarter, remove a quarter, turning the crank and display
gumball.
*/

// State Interface
interface State
{
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}

// No Quarter State
class NoQuarterState implements State
{
    GumballMachine gumballMachine;

    NoQuarterState(GumballMachine gumballMachine)
    {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter()
    {
        System.out.println("You inserted a quarter.");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    public void ejectQuarter()
    {
        System.out.println("You haven't inserted a quarter.");
    }

    public void turnCrank()
    {
        System.out.println("You turned, but there's no quarter.");
    }

    public void dispense()
    {
        System.out.println("You need to pay first.");
    }
}

// Has Quarter State
class HasQuarterState implements State
{
    GumballMachine gumballMachine;

    HasQuarterState(GumballMachine gumballMachine)
    {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter()
    {
        System.out.println("You can't insert another quarter.");
    }

    public void ejectQuarter()
    {
        System.out.println("Quarter returned.");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    public void turnCrank()
    {
        System.out.println("You turned the crank.");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    public void dispense()
    {
        System.out.println("No gumball dispensed.");
    }
}

// Sold State
class SoldState implements State
{
    GumballMachine gumballMachine;

    SoldState(GumballMachine gumballMachine)
    {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter()
    {
        System.out.println("Please wait, we're already giving you a gumball.");
    }

    public void ejectQuarter()
    {
        System.out.println("Sorry, you already turned the crank.");
    }

    public void turnCrank()
    {
        System.out.println("Turning twice doesn't get you another gumball.");
    }

    public void dispense()
    {
        gumballMachine.releaseBall();

        if(gumballMachine.getCount() > 0)
        {
            gumballMachine.setState(
                gumballMachine.getNoQuarterState());
        }
        else
        {
            System.out.println("Oops! Out of gumballs.");
            gumballMachine.setState(
                gumballMachine.getSoldOutState());
        }
    }
}

// Sold Out State
class SoldOutState implements State
{
    GumballMachine gumballMachine;

    SoldOutState(GumballMachine gumballMachine)
    {
        this.gumballMachine = gumballMachine;
    }

    public void insertQuarter()
    {
        System.out.println("You can't insert a quarter, the machine is sold out.");
    }

    public void ejectQuarter()
    {
        System.out.println("You haven't inserted a quarter.");
    }

    public void turnCrank()
    {
        System.out.println("You turned, but there are no gumballs.");
    }

    public void dispense()
    {
        System.out.println("No gumball dispensed.");
    }
}

// Gumball Machine
class GumballMachine
{
    // Current state
    State state;

    // All possible states
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    int count;

    GumballMachine(int numberOfGumballs)
    {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);

        count = numberOfGumballs;

        if(count > 0)
            state = noQuarterState;
        else
            state = soldOutState;
    }

    void insertQuarter()
    {
        state.insertQuarter();
    }

    void ejectQuarter()
    {
        state.ejectQuarter();
    }

    void turnCrank()
    {
        state.turnCrank();
        state.dispense();
    }

    void setState(State state)
    {
        this.state = state;
    }

    void releaseBall()
    {
        if(count > 0)
        {
            System.out.println("A gumball comes rolling out...");
            count--;
        }
    }

    int getCount()
    {
        return count;
    }

    State getSoldOutState()
    {
        return soldOutState;
    }

    State getNoQuarterState()
    {
        return noQuarterState;
    }

    State getHasQuarterState()
    {
        return hasQuarterState;
    }

    State getSoldState()
    {
        return soldState;
    }
}

// Main Class
public class EX-GumballMachineTest
{
    public static void main(String[] args)
    {
        GumballMachine machine =
                new GumballMachine(2);

        System.out.println("Gumball Machine Started");
        System.out.println("Gumballs available: "
                + machine.getCount());

        System.out.println();

        machine.insertQuarter();

        machine.turnCrank();

        System.out.println();

        machine.insertQuarter();

        machine.ejectQuarter();

        System.out.println();

        machine.insertQuarter();

        machine.turnCrank();

        System.out.println();

        System.out.println("Gumballs remaining: "
                + machine.getCount());
    }
}