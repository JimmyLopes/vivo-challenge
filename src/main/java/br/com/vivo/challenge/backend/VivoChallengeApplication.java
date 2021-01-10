package br.com.vivo.challenge.backend;

import br.com.vivo.challenge.backend.domain.Heroi;
import br.com.vivo.challenge.backend.domain.Volta;
import br.com.vivo.challenge.backend.repository.HeroiRepository;
import br.com.vivo.challenge.backend.repository.VoltaRepository;
import br.com.vivo.challenge.backend.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class VivoChallengeApplication implements CommandLineRunner {

	@Autowired
	private HeroiRepository heroiRepository;
	@Autowired
	private VoltaRepository voltaRepository;

	public static void main(String[] args) {
		SpringApplication.run(VivoChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Limpa a base
		heroiRepository.deleteAll();
		voltaRepository.deleteAll();

		Heroi superman = new Heroi();
		superman.setNome("Superman");
		superman.setCodigo("038");

		Volta v1Superman = new Volta();
		v1Superman.setIdVolta("1");
		v1Superman.setNumeroVolta(1);
		v1Superman.setVelocidadeVolta(44.275);
		v1Superman.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:48:05.575"));
		v1Superman.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:49:08.277"));

		Volta v2Superman = new Volta();
		v2Superman.setIdVolta("2");
		v2Superman.setNumeroVolta(2);
		v2Superman.setVelocidadeVolta(44.053);
		v2Superman.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:49:08.277"));
		v2Superman.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:50:11.447"));

		Volta v3Superman = new Volta();
		v3Superman.setIdVolta("3");
		v3Superman.setNumeroVolta(3);
		v3Superman.setVelocidadeVolta(44.334);
		v3Superman.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:50:11.447"));
		v3Superman.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:51:14.216"));

		Volta v4Superman = new Volta();
		v4Superman.setIdVolta("4");
		v4Superman.setNumeroVolta(4);
		v4Superman.setVelocidadeVolta(44.321);
		v4Superman.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:51:14.216"));
		v4Superman.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:52:17.003"));

		superman.setVoltasHeroi(Arrays.asList(v1Superman, v2Superman, v3Superman, v4Superman));

		Heroi flash = new Heroi();
		flash.setNome("Flash");
		flash.setCodigo("033");

		Volta v1Flash = new Volta();
		v1Flash.setIdVolta("5");
		v1Flash.setNumeroVolta(1);
		v1Flash.setVelocidadeVolta(43.243);
		v1Flash.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:48:06.506"));
		v1Flash.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:49:10.858"));

		Volta v2Flash = new Volta();
		v2Flash.setIdVolta("6");
		v2Flash.setNumeroVolta(2);
		v2Flash.setVelocidadeVolta(43.48);
		v2Flash.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:49:10.031"));
		v2Flash.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:50:14.860"));

		Volta v3Flash = new Volta();
		v3Flash.setIdVolta("7");
		v3Flash.setNumeroVolta(3);
		v3Flash.setVelocidadeVolta(43.675);
		v3Flash.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:50:14.860"));
		v3Flash.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:51:18.576"));

		Volta v4Flash = new Volta();
		v4Flash.setIdVolta("8");
		v4Flash.setNumeroVolta(4);
		v4Flash.setVelocidadeVolta(43.474);
		v4Flash.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:51:18.576"));
		v4Flash.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:52:22.586"));

		flash.setVoltasHeroi(Arrays.asList(v1Flash, v2Flash, v3Flash, v4Flash));

		Heroi mercurio = new Heroi();
		mercurio.setNome("Mercúrio");
		mercurio.setCodigo("002");

		Volta v1Mercurio = new Volta();
		v1Mercurio.setIdVolta("9");
		v1Mercurio.setNumeroVolta(1);
		v1Mercurio.setVelocidadeVolta(43.408);
		v1Mercurio.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:48:06.967"));
		v1Mercurio.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:49:11.075"));

		Volta v2Mercurio = new Volta();
		v2Mercurio.setIdVolta("10");
		v2Mercurio.setNumeroVolta(2);
		v2Mercurio.setVelocidadeVolta(43.493);
		v2Mercurio.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:49:11.020"));
		v2Mercurio.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:50:15.057"));

		Volta v3Mercurio = new Volta();
		v3Mercurio.setIdVolta("11");
		v3Mercurio.setNumeroVolta(3);
		v3Mercurio.setVelocidadeVolta(43.49);
		v3Mercurio.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:50:15.057"));
		v3Mercurio.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:51:19.044"));

		Volta v4Mercurio = new Volta();
		v4Mercurio.setIdVolta("12");
		v4Mercurio.setNumeroVolta(4);
		v4Mercurio.setVelocidadeVolta(44.118);
		v4Mercurio.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:51:19.044"));
		v4Mercurio.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:52:22.120"));

		mercurio.setVoltasHeroi(Arrays.asList(v1Mercurio, v2Mercurio, v3Mercurio, v4Mercurio));

		Heroi sonic = new Heroi();
		sonic.setNome("Sonic");
		sonic.setCodigo("023");

		Volta v1Sonic = new Volta();
		v1Sonic.setIdVolta("13");
		v1Sonic.setNumeroVolta(1);
		v1Sonic.setVelocidadeVolta(43.202);
		v1Sonic.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:48:08.253"));
		v1Sonic.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:49:12.667"));

		Volta v2Sonic = new Volta();
		v2Sonic.setIdVolta("14");
		v2Sonic.setNumeroVolta(2);
		v2Sonic.setVelocidadeVolta(42.941);
		v2Sonic.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:49:12.667"));
		v2Sonic.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:50:17.472"));

		Volta v3Sonic = new Volta();
		v3Sonic.setIdVolta("15");
		v3Sonic.setNumeroVolta(3);
		v3Sonic.setVelocidadeVolta(43.287);
		v3Sonic.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:50:17.472"));
		v3Sonic.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:51:21.759"));

		Volta v4Sonic = new Volta();
		v4Sonic.setIdVolta("16");
		v4Sonic.setNumeroVolta(4);
		v4Sonic.setVelocidadeVolta(43.335);
		v4Sonic.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:51:21.759"));
		v4Sonic.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:52:25.975"));

		sonic.setVoltasHeroi(Arrays.asList(v1Sonic, v2Sonic, v3Sonic, v4Sonic));

		Heroi papalegua = new Heroi();
		papalegua.setNome("PAPALÉGUA");
		papalegua.setCodigo("015");

		Volta v1Papalegua = new Volta();
		v1Papalegua.setIdVolta("17");
		v1Papalegua.setNumeroVolta(1);
		v1Papalegua.setVelocidadeVolta(43.202);
		v1Papalegua.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:48:12.520"));
		v1Papalegua.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:49:30.976"));

		Volta v2Papalegua = new Volta();
		v2Papalegua.setIdVolta("18");
		v2Papalegua.setNumeroVolta(2);
		v2Papalegua.setVelocidadeVolta(42.941);
		v2Papalegua.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:49:30.976"));
		v2Papalegua.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:50:37.987"));

		Volta v3Papalegua = new Volta();
		v3Papalegua.setIdVolta("19");
		v3Papalegua.setNumeroVolta(3);
		v3Papalegua.setVelocidadeVolta(43.287);
		v3Papalegua.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:50:37.987"));
		v3Papalegua.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:51:46.691"));

		Volta v4Papalegua = new Volta();
		v4Papalegua.setIdVolta("20");
		v4Papalegua.setNumeroVolta(4);
		v4Papalegua.setVelocidadeVolta(43.335);
		v4Papalegua.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:51:46.691"));
		v4Papalegua.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:53:06.741"));

		papalegua.setVoltasHeroi(Arrays.asList(v1Papalegua, v2Papalegua, v3Papalegua, v4Papalegua));

		Heroi gato = new Heroi();
		gato.setNome("GATOAJATO");
		gato.setCodigo("011");

		Volta v1Gato = new Volta();
		v1Gato.setIdVolta("21");
		v1Gato.setNumeroVolta(1);
		v1Gato.setVelocidadeVolta(13.169);
		v1Gato.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:48:30.481"));
		v1Gato.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:52:01.796"));

		Volta v2Gato = new Volta();
		v2Gato.setIdVolta("22");
		v2Gato.setNumeroVolta(2);
		v2Gato.setVelocidadeVolta(28.435);
		v2Gato.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:52:01.796"));
		v2Gato.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:50:37.987"));

		Volta v3Gato = new Volta();
		v3Gato.setIdVolta("23");
		v3Gato.setNumeroVolta(3);
		v3Gato.setVelocidadeVolta(35.633);
		v3Gato.setInicioVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:50:37.987"));
		v3Gato.setFimVolta(DateUtils.getLocalDateTimeFromString("2021-01-09 23:53:39.660"));

		papalegua.setVoltasHeroi(Arrays.asList(v1Gato, v2Gato, v3Gato));

		heroiRepository.saveAll(Arrays.asList(superman, flash, mercurio, sonic, papalegua, gato));
	}
}
