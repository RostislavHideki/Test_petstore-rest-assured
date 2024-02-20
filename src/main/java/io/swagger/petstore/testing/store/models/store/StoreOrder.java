package io.swagger.petstore.testing.store.models.store;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class StoreOrder {
    public Integer id;
    public Integer petId;
    public Integer quantity;
    public String shipDate;
    public Status status;
    public Boolean complete;
}
