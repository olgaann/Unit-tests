package task;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class MagicBoxTest {

    static MagicBox<String> boxString = new MagicBox<>("boxString", 2);
    static MagicBox<Integer> boxInt;
    static List<Integer> list = Arrays.asList(11, 49, 8, -9, 74, 5);

    @BeforeAll
    static void setUp() {
        boxInt = new MagicBox<>("boxInt", list.size());
    }


    @DisplayName("Тестирование метода boolean add()")
    @ParameterizedTest
    @MethodSource("getArguments")
    void addTest(String item, boolean isAdded) {
        Assertions.assertEquals(isAdded, boxString.add(item));
    }

    private static Stream<Arguments> getArguments() {
        return Stream.of(
                Arguments.of("один", true),
                Arguments.of("два", true),
                Arguments.of("три", false)
        );
    }


    @DisplayName("Тестирование метода T pick()")
    @Test
    void pickTest() {

        for (Integer i : list) {
            boxInt.add(i);
        }

        Set<Integer> set = new HashSet<Integer>(list);
        Assertions.assertTrue(set.contains(boxInt.pick()));

//        int random = boxInt.pick();
//        boolean result = list.stream().anyMatch(value -> value.equals(random));
//        assert result;
    }


    @DisplayName("Тестирование метода T pick() на выброс исключения")
    @Test
    void pickTestEx() {
        boxInt.add(list.get(1));
        Assertions.assertThrows(RuntimeException.class, () -> boxInt.pick());
    }


}
