package pl.coderslab.carmanagement.converters;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.coderslab.carmanagement.dtos.AdvertFormDTO;
import pl.coderslab.carmanagement.dtos.UserDTO;
import pl.coderslab.carmanagement.entity.Advert;
import pl.coderslab.carmanagement.model.user.User;


@Mapper
public interface MyConverter {

    MyConverter INSTANCE = Mappers.getMapper(MyConverter.class);

    UserDTO userDTO(User user);
    AdvertFormDTO advertDTO(Advert advert);
    Advert advert(AdvertFormDTO advertDTO);
}
