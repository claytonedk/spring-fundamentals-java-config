import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.kuhn.enums.CustomerType;
import com.kuhn.strategy.discount.DiscountCalc;
import com.kuhn.strategy.discount.DiscountCalcGold;
import com.kuhn.strategy.discount.DiscountCalcNormal;
import com.kuhn.strategy.discount.DiscountCalcPlatinum;
import com.kuhn.strategy.discount.DiscountCalcSilver;

@Configuration
@ComponentScan("com.kuhn")
public class AppConfig {
	
	@Bean
	public Map<CustomerType, DiscountCalc> mapDiscount() {
		Map<CustomerType, DiscountCalc> mapDiscount = new HashMap<>();
		mapDiscount.put(CustomerType.NORMAL, new DiscountCalcNormal());
		mapDiscount.put(CustomerType.SILVER, new DiscountCalcSilver());
		mapDiscount.put(CustomerType.GOLD, new DiscountCalcGold());
		mapDiscount.put(CustomerType.PLATINUM, new DiscountCalcPlatinum());
		
		return mapDiscount;
	}
	
}
