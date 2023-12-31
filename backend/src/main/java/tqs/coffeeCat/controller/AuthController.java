package tqs.coffeeCat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import tqs.coffeeCat.payload.request.LoginRequest;
import tqs.coffeeCat.payload.request.RegisterRequest;
import tqs.coffeeCat.service.AuthService;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthService authService;

	@Autowired
	public AuthController(AuthService authService,
			@Qualifier("customUserDetailsService") UserDetailsService userDetailsService) {
		this.authService = authService;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		try {
			String username = loginRequest.getUsername();
			String password = loginRequest.getPassword();
			authService.loginUser(username, password);

			Map<String, Object> responseBody = new HashMap<>();
			responseBody.put("status", HttpStatus.OK.value());
			responseBody.put("username", username);

			return ResponseEntity.ok().body(responseBody);
		} catch (AuthenticationException e) {
			Map<String, Object> errorBody = new HashMap<>();
			errorBody.put("status", HttpStatus.UNAUTHORIZED.value());
			errorBody.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
		String email = registerRequest.getEmail();
		String username = registerRequest.getUsername();
		String password = registerRequest.getPassword();

		try {
			authService.registerUser(username, email, password);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}

		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("message", "Registration successful");
		responseBody.put("username", username);
		responseBody.put("email", email);

		return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
	}
}
