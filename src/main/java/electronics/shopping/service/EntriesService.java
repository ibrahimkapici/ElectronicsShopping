package electronics.shopping.service;

import electronics.shopping.model.Cart;
import electronics.shopping.model.Entries;
import electronics.shopping.repository.EntriesRepository;
import electronics.shopping.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntriesService {
    private EntriesRepository entriesRepository;

    public EntriesService(EntriesRepository entriesRepository) {
        this.entriesRepository = entriesRepository;
    }

    ProductRepository productRepository;

    public List<Entries> findByEntryId(long id) {
        return entriesRepository.findAllById(id);
    }
//    public Optional<Entries> getPriceByProductId(double price){
//       return entriesRepository.findById(getPriceByProductId(price).get());
//    }

//    public Entries calculatePrice(Double price) {
//        Double totalPrice = 0D;
//        Double kdvRate = 1.18;
//        Double totalPricePlusKdv = 0D;
//        List<Entries> entriesList = entriesRepository.findAllByEntryId(entries.getId());
//        entriesList.add(entriesRepository.findAllByEntryId().ge);
//
//        if (entriesList.stream().count() > 0) {
//            for (Entries quantity : entriesList) {
//                Double itemPrice = entriesRepository.getPriceByProductId(quantity.getProductId()).get().getPrice();
//                Double priceForEachProduct = itemPrice * quantity.getCount();
//                totalPrice = totalPrice + priceForEachProduct;
//                totalPricePlusKdv = totalPrice * kdvRate;
//            }
//            entries.setPrice(totalPricePlusKdv);
//        } else {
//            Double itemPrice = entriesRepository.getPriceByProductId(entries.getProductId()).get().getPrice();
//            Double priceForEachProduct = itemPrice * entries.getCount();
//        }
//
//        Entries entry = new Entries();
//        entriesRepository.save(entry);
//
//        return entriesRepository.calculatePrice(entry);
//    }
//}

//    public Entries calculatePrice(Entries entries) {
//        Double totalPrice = 0D;
//        Double kdvRate = 1.18;
//        Double totalPricePlusKdv = 0D;
//        List<Entries> entriesList = entriesRepository.findAllById(entries.getId());
//        entriesList.add(entries);
//
//        for (Entries entry : entriesList) {
//            totalPrice = entry.getPrice() * entries.getCount();
//            totalPricePlusKdv = totalPrice * kdvRate;
//            entry.setPrice(totalPricePlusKdv);
//           // entriesRepository.save(entry);
//        }
//        Entries entries1 = entriesRepository.save(entries);
//        return entries1;
//    }
//        if (entriesList.stream().count() > 0) {
//            for (Entries quantity : entriesList) {
//                Double itemPrice = entriesRepository.getPriceByProductId(quantity.getProductId()).get().getPrice();
//                Double priceForEachProduct = itemPrice * quantity.getCount();
//                totalPrice += priceForEachProduct;
//                totalPricePlusKdv = totalPrice * kdvRate;
//            }
//            entries.setPrice(totalPricePlusKdv);
//        } else {
//            Double itemPrice = entriesRepository.getPriceByProductId(entries.getProductId()).get().getPrice();
//            Double priceForEachProduct = itemPrice * entries.getCount();
//        }
//
//        Entries entry = new Entries();
//        entriesRepository.save(entry);
//
//        return entriesRepository.calculatePrice(entry);

//    public Cart addToCart(Cart cart){
//        Entries entries = new Entries();
//        entriesRepository.calculatePrice(entries);
//        List<Entries> entriesList = new ArrayList<>();
//        entriesList.add(entries);
//        Cart cart1 = addToCart(entries.getCart());
//        return cart1;
//    }

    public Entries findById(long id) {
       return entriesRepository.getById(id);
    }

    public Entries save(Entries entries) {
        return entriesRepository.save(entries);
    }
}
