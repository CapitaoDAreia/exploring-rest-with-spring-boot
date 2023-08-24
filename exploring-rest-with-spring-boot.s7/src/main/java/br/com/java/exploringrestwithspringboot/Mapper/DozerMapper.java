package br.com.java.exploringrestwithspringboot.Mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static <O, D> @NotNull List<D> parseListObjects(@NotNull List<O> origin, Class<D> destination){
        List<D> destinationObjects = new ArrayList<D>();
        for (O o : origin){
            destinationObjects.add(mapper.map(o, destination));
        }

        return destinationObjects;
    }
}
