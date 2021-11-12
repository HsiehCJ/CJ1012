package tw.com.fcb.mimosa.examples.gettingstarted;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import tw.com.fcb.mimosa.domain.t9n.Term;
import tw.com.fcb.mimosa.domain.t9n.Translated;
import tw.com.fcb.mimosa.domain.t9n.TranslationService;
import tw.com.fcb.mimosa.http.APIErrorException;

@Service
@AllArgsConstructor
public class MyErrorTranslation implements TranslationService {

	final ErrorService errservice;
	@Override
	public Optional<Translated> translate(@NonNull Term term) {
		if (term.getCode().equals("ERR1")) {
			return Optional.of(
				new MyTranslation(term.getCategory(),
						term.getCode(),
						errservice.getByCode(term.getCode()).getTranslation()));
		}
		
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	

	@Getter
	@RequiredArgsConstructor
	static class MyTranslation implements Translated {
		final String category;
		final String code;
		final String translation;
	}

	
}