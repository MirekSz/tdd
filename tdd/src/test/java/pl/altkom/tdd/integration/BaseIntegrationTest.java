package pl.altkom.tdd.integration;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import pl.altkom.tdd.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
@org.springframework.transaction.annotation.Transactional
@SpringApplicationConfiguration(classes = { Application.class })
@TransactionConfiguration(defaultRollback = true)
public class BaseIntegrationTest {

	// @Autowired
	// protected GlobalExceptionHandler exceptionHandler;
	// @Autowired
	// ObjectMapper ob;
	//
	// protected <O> O convert(final MvcResult result, final Class<O> clazz) {
	// try {
	// return ob.readValue(result.getResponse().getContentAsString(),
	// clazz);
	// } catch (Exception e) {
	// throw new RuntimeException();
	// }
	// }
	//
	// protected <O> O convert(final String value, final Class<O> clazz) {
	// try {
	// return ob.readValue(value, clazz);
	// } catch (Exception e) {
	// throw new RuntimeException();
	// }
	// }
	//
	// protected String toString(final Object object) throws Exception {
	// return ob.writeValueAsString(object);
	// }
	//
	// protected <O> List<O> convertList(final MvcResult result,
	// final Class<O> clazz) {
	// try {
	// JavaType type = ob.getTypeFactory().constructCollectionType(
	// List.class, clazz);
	// return ob
	// .readValue(result.getResponse().getContentAsString(), type);
	// } catch (Exception e) {
	// e.printStackTrace();
	// throw new RuntimeException();
	// }
	// }
	//
	// protected ExceptionHandlerExceptionResolver createExceptionResolver() {
	// ExceptionHandlerExceptionResolver exceptionResolver = new
	// ExceptionHandlerExceptionResolver() {
	//
	// @Override
	// protected ServletInvocableHandlerMethod getExceptionHandlerMethod(
	// final HandlerMethod handlerMethod, final Exception exception) {
	// Method method = new ExceptionHandlerMethodResolver(
	// GlobalExceptionHandler.class).resolveMethod(exception);
	// return new ServletInvocableHandlerMethod(exceptionHandler,
	// method);
	// }
	// };
	// exceptionResolver.getMessageConverters().add(
	// new MappingJackson2HttpMessageConverter());
	// exceptionResolver.afterPropertiesSet();
	// return exceptionResolver;
	// }
	//
	// @Profile(Profiles.TEST)
	// @Aspect
	// @Component
	// public static class EMFlusher {
	//
	// @PersistenceContext
	// EntityManager em;
	//
	// @AfterReturning("@within(org.springframework.stereotype.Service)")
	// public void logServiceAccess(final JoinPoint joinPoint) {
	// em.flush();
	// em.clear();
	// }
	//
	// }
}
