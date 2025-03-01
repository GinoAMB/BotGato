package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class  MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "";
    public static final String TOKEN = "";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        if(getMessageText().equals("/start")) {
            setUserGlory(0);

            sendPhotoMessageAsync("step_1_pic");

            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera","step_1_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);

            sendPhotoMessageAsync("step_2_pic");

            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("!Tomar una salchicha¡ +20 de fama", "step_2_btn",
                            "!Tomar un pescado¡ +20 de fama", "step_2_btn",
                            "!Tirar una lata de pepinillo¡ +20 de fama", "step_2_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);

            sendPhotoMessageAsync("step_3_pic");

            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Hackear al robot aspiradora", "step_3_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(30);

            sendPhotoMessageAsync("step_4_pic");

            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot aspiradora a por comida! +30 de fama", "step_4_btn",
                            "Dar un paseo en el robot aspiradora! +30 de fama", "step_4_btn",
                            "¡Huir del robot aspiradora! +30 de fama", "step_4_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_4_btn")){
            setUserGlory(30);

            sendPhotoMessageAsync("step_5_pic");

            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("¡Activar la GoPro en modo visión nocturna!","step_5_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_5_btn")){
            setUserGlory(40);

            sendPhotoMessageAsync("step_6_pic");

            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Galletas de atún +40 de fama","step_6_btn",
                            "Un collar con GPS +40 de fama","step_6_btn",
                            "Un juguete láser +40 de fama","step_6_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")){
            setUserGlory(40);

            sendPhotoMessageAsync("step_7_pic");

            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Usar un ataque de fuerza bruta (miau-miau-miau)","step_7_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_7_btn")){
            setUserGlory(50);

            sendPhotoMessageAsync("step_8_pic");

            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Instalar un software para dominar la casa","step_8_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_8_btn")){
            setUserGlory(50);

            sendPhotoMessageAsync("final_pic");

            sendTextMessageAsync(FINAL_TEXT,Map.of());
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}