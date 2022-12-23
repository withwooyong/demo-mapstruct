package com.example.demomapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper
public interface CarMapper {

    CarMapper MAPPER = Mappers.getMapper(CarMapper.class);

    @Named("uuid")
    static UUID uuid(Long id) {
        String uuidString = String.format("%032d", id.intValue());
        System.out.println(uuidString);
        long mostSig = Long.parseLong(uuidString.substring(0, 16), 16);
        long leastSig = Long.parseLong(uuidString.substring(16, 32), 16);
        return new UUID(mostSig, leastSig);
    }

//    @Named("uuids")
//    static List<UUID> uuids(List<Long> ids) {
//        System.out.println("uuids ============");
//        List<UUID> uuidList = new ArrayList<>();
//
//        ids.forEach(aLong -> {
//            String uuidString = String.format("%32d", aLong);
//            long mostSig = Long.parseLong(uuidString.substring(0, 16), 16);
//            long leastSig = Long.parseLong(uuidString.substring(16, 32), 16);
//            uuidList.add(new UUID(mostSig, leastSig));
//        });
//        return uuidList;
//    }

    @Mapping(source = "id", target = "id", qualifiedByName = "uuid")
    Car toCar(CarDTO car);

    //    @Mapping(source = "id", target = "id")
    List<Car> toCars(List<CarDTO> car);
//    @IterableMapping(numberFormat = "$#.00")
//    List<String> ids(List<Integer> ids);
}
