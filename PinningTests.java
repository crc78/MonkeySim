import org.junit.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class PinningTests {


    @Test
    public void oldFirstMonkey1(){
        List<Monkey> list = new ArrayList<Monkey>();
        Monkey mock1 = mock(Monkey.class);
        Monkey mock2 = mock(Monkey.class);
        list.add(mock1);
        list.add(mock2);

        when(mock1.getMonkeyNum()).thenReturn(1);
        when(mock2.getMonkeyNum()).thenReturn(2);

        Monkey result = OldMonkeySim.getFirstMonkey(list);

        assertSame(result, mock1);
    }

    @Test
    public void oldFirstMonkey2(){
        List<Monkey> list = new ArrayList<Monkey>();

        Monkey result = OldMonkeySim.getFirstMonkey(list);

        assertNull(result);
    }

    @Test
    public void newFirstMonkey1(){
        List<Monkey> list = new ArrayList<Monkey>();
        Monkey mock1 = mock(Monkey.class);
        Monkey mock2 = mock(Monkey.class);
        list.add(mock1);
        list.add(mock2);

        when(mock1.getMonkeyNum()).thenReturn(1);
        when(mock2.getMonkeyNum()).thenReturn(2);

        Monkey result = MonkeySim.getFirstMonkey(list);

        assertSame(result, mock1);
    }

    @Test
    public void newFirstMonkey2(){
        List<Monkey> list = new ArrayList<Monkey>();

        Monkey result = MonkeySim.getFirstMonkey(list);

        assertNull(result);
    }

    @Test
    public void oldStringify1() throws Exception {
        Monkey m1 = mock(Monkey.class);
        Monkey m2 = mock(Monkey.class);

        when(m1.getMonkeyNum()).thenReturn(1);
        when(m2.getMonkeyNum()).thenReturn(2);
        when(m1.getId()).thenReturn(200);
        when(m2.getId()).thenReturn(300);

        String result = OldMonkeySim.stringifyResults(12, m1, m2);
        assertTrue(result.equals("//Round 12: Threw banana from Monkey (#1 / ID 200) to Monkey (#2 / ID 300)"));

    }

    @Test
    public void oldStringify2() throws Exception {
        Monkey m1 = mock(Monkey.class);
        Monkey m2 = mock(Monkey.class);

        when(m1.getMonkeyNum()).thenReturn(-60);
        when(m2.getMonkeyNum()).thenReturn(-61);
        when(m1.getId()).thenReturn(-1234);
        when(m2.getId()).thenReturn(-4567);

        String result = OldMonkeySim.stringifyResults(-999, m1, m2);
        assertTrue(result.equals("//Round -999: Threw banana from Monkey (#-60 / ID -1234) to Monkey (#-61 / ID -4567)"));
    }

    @Test
    public void newStringify1() throws Exception {
        Monkey m1 = mock(Monkey.class);
        Monkey m2 = mock(Monkey.class);

        when(m1.getMonkeyNum()).thenReturn(1);
        when(m2.getMonkeyNum()).thenReturn(2);
        when(m1.getId()).thenReturn(200);
        when(m2.getId()).thenReturn(300);

        String result = MonkeySim.stringifyResults(12, m1, m2);
        assertTrue(result.equals("//Round 12: Threw banana from Monkey (#1 / ID 200) to Monkey (#2 / ID 300)"));
    }

    @Test
    public void newStringify2() throws Exception {
        Monkey m1 = mock(Monkey.class);
        Monkey m2 = mock(Monkey.class);

        when(m1.getMonkeyNum()).thenReturn(-60);
        when(m2.getMonkeyNum()).thenReturn(-61);
        when(m1.getId()).thenReturn(-1234);
        when(m2.getId()).thenReturn(-4567);

        String result = MonkeySim.stringifyResults(-999, m1, m2);
        assertTrue(result.equals("//Round -999: Threw banana from Monkey (#-60 / ID -1234) to Monkey (#-61 / ID -4567)"));
    }
}
