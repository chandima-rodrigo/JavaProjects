//Test Rest services using mockito
 
 
package com.organization;
 
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
 
public class MockitoTest {
       
        @Test
        public void iterator_will_return_hello_world(){
          System.out.println("Test ");
          //arrange
          Iterator i = mock(Iterator.class);
          when(i.next()).thenReturn("Hello").thenReturn("World");
          //act
          String result=i.next()+" "+i.next();
          //assert
          assertEquals("Do the values equate? ", "Hello World", result);
        }
 
        @Test
        public void with_arguments(){
          Comparable c=mock(Comparable.class);
          when(c.compareTo("Test")).thenReturn(2);
          assertEquals(2,c.compareTo("Test"));
        }
       
        @Test
        public void test1()  {
           // create mock
           MyClass test = Mockito.mock(MyClass.class);//Mock the class. So method won't be actually called.
          
           // DEFINE return value for method getUniqueId().
           //We Specify the value what to expect and then test it.
           when(test.getUniqueId()).thenReturn(43);
           when(test.getValuePlusFive(20)).thenReturn(27);
          
           // use mock in test....
           assertEquals(test.getUniqueId(), 43);
           assertEquals(test.getValuePlusFive(20), 27);//Method is mocked. So retrun what ever we say.
        }
       
       
        @Test
        public void test2()  {
                  // create and configure mock
                  MyClass test = Mockito.mock(MyClass.class);
                  when(test.getUniqueId()).thenReturn(43);
                 
                  //call method testing on the mock with parameter 30
                  test.getValuePlusFive(30);
        }