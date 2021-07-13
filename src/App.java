
import java.util.Random;

/**
 * 
 * @version $Id:$
 */
final class App {
    /**
     * ��ʕ�
     */
    private static int DISP_WIDTH;

    /**
     * ��ʍ�
     */
    private static int DISP_HEIGHT;

    /**
     * �`�敝
     */
    private final static int WIDTH = 240;

    /**
     * �`�捂
     */
    private final static int HEIGHT = 240;

    /**
     * ���݂̃V�[���ԍ�
     */
    private static int scene;

    /**
     * �V�[���ԍ�:������
     */
    private static final int SCENE_INIT = 0;

    /**
     * �V�[���ԍ�:���S
     */
    private final static int SCENE_LOGO = 1;

    /**
     * �V�[���ԍ�:�^�C�g��
     */
    private final static int SCENE_TITLE = 2;

    /**
     * �V�[���ԍ�:�Q�[��
     */
    private final static int SCENE_GAME = 3;

    /**
     * �V�[���ԍ�:�Q�[���I�[�o�[
     */
    private final static int SCENE_GAMEOVER = 4;

    /**
     * �V�[���ԍ�:�n�C�X�R�A
     */
    private final static int SCENE_HIGHSCORE = 6;

    /**
     * �V�[���ԍ�:������
     */
    private final static int SCENE_SETUMEI = 7;

    /**
     * ?
     */
    private static int count;

    /**
     * ?
     */
    private static int bcount;

    /**
     * �X�R�A
     */
    private static int score;

    /**
     * �j���̑傫��
     */
    private static int holesize;

    /**
     * ���������j�{��
     */
    private static int haricount;

    /**
     * ���̂�
     */
    private static int ix;

    /**
     * ���̂�
     */
    private static int[] iy = new int[30];

    /**
     * ���̕ψ�
     */
    private static int vy;

    /**
     * �j�̂�
     */
    private static int[] hx = new int[10];

    /**
     * �j�̂�
     */
    private static int[] hy = new int[10];

    /**
     * �j�̕ϐ��p
     */
    private static int[] hvar = new int[10];

    /**
     * ?
     */
    private static int select;

    /**
     * ?
     */
    private static boolean pause;

    /**
     * �����L���O����
     */
    private static int rank;

    /**
     * �����L���O�̃X�R�A�ێ�
     */
    private static int[] scranking = new int[10];

    /**
     * ��������
     */
    private static final Random rand = new Random();

    /**
     * �摜�Ǘ��ԍ�:���S
     */
    private static final int IMAGE_LOGO = 0;

    /**
     * �摜�Ǘ��ԍ�:�^�C�g��
     */
    private static final int IMAGE_TITLE = 1;

    /**
     * �摜
     */
    private static Object[] image = new Object[24];

    /**
     * �摜�̍���
     */
    private static int[] imageHeight = new int[image.length];
    /**
     * �摜�̕�
     */
    private static int[] imageWidth = new int[image.length];
    /**
     * �摜�傫�Ȑ���
     */
    private static Object imageBigNum;
    /**
     * �����Ȑ����̉摜
     */
    private static Object imageLitNum;
    /**
     * ��
     */
    private static final Object[] sounds = new Object[3];
    /**
     * �����̃~���[�g
     */
    private static boolean muteSound;
    /**
     * �T�E���h�F���S
     */
    private static final int SOUND_LOGO = 0;

    /**
     * �T�E���h�F�j�ʉ�
     */
    private static final int SOUND_PASS = 1;
    /**
     * �T�E���h�F���j
     */
    private static final int SOUND_GAMEOVER = 2;
    /**
     * ������
     */
    private static final String[] SETUMEI = {
            "���𑀍삵�Ď��X�łĂ���j���Ɏ���",
            "�ʂ��Ă����Q�[���ł��B�ʂ����{����", 
            "�����Ă����ɂ�j�����������Ȃ���", 
            "����A�j�̊Ԋu�������Ȃ�ȂǁA����",
            "�����Փx���オ���Ă����܂��B�@�@", 
            "�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@", 
            "�@����L�[�����@�@�@���̏㏸�@�@�@",
            "�@���{�^���@�@�@�@�@����ON/OFF�@�@", 
            "�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@�@", 
            "�n�C�X�R�A��ʂŃl�b�g�����L���O��",
            "�Q���ł��S���̃v���C���[�ƋL�^����",
            "���܂��B�@�@�@�@�@�@�@�@�@�@�@�@�@" 
    };

    /**
     * ��ʃZ���^�[�ʒu
     */
    private static final int CENTER_X = WIDTH  / 2;
    /**
     * ��ʃZ���^�[�ʒu
     */
    private static final int CENTER_Y = HEIGHT / 2;
    /**
     * �j���̍ŏ��T�C�Y
     */
    private static final int HVAR_MIN   = 5;
    /**
     * �j���̃X�^�[�g���̃T�C�Y
     */
    private static final int HVAR_START = 30;
    /**
     * �^�C�g����ʃ\�t�g�L�[
     */
    private static final String[] SOFTKEY_TITLE = { null, "�I��"};
    /**
     * �Q�[����ʂ̃\�t�g�L�[
     */
    private static final String[] SOFTKEY_GAME = { "�߰��", "����" };
    /**
     * �Q�[���I�[�o��ʂ̃\�t�g�L�[
     */
    private static final String[] SOFTKEY_GAMEOVER = {null,"����" };
    /**
     * �n�C�X�R�A
     */
    private static final String[] SOFTKEY_HIGHSCORE = { "�߂�", null};
    /**
     * �^�C�g������̃z�[���y�[�W���J����
     */
    private static final String URL_HOME = "http://appget.com/";
    /**
     * ���j�A�j���[�V������
     */
    private static final int ANIM_NUM_BAKUHA = 8;
    /**
     * ���[�v������
     */
    final static void process() {
        switch (scene) {
        case SCENE_INIT:
            processInit();
            break;
        case SCENE_LOGO:
            processLogo();
            break;
        case SCENE_TITLE:
            processTitle();
            break;
        case SCENE_GAME:
            processGame();
            break;
        case SCENE_GAMEOVER:
            processGameOver();
            break;
        case SCENE_HIGHSCORE:
            processHighscore();
            break;
        case SCENE_SETUMEI:
            processSetumei();
            break;
        }
        OS.repaint();
    }

    /**
     * ��ʕ`��
     */
    final static void paint() {
        OS.setRGB(0x000000);
        OS.fillRect(0, 0, DISP_WIDTH, DISP_HEIGHT);
        switch (scene) {
        case SCENE_INIT:
            paintInit();
            break;
        case SCENE_LOGO:
            paintLogo();
            break;
        case SCENE_TITLE:
            paintTitle();
            break;
        case SCENE_GAME:
            paintGame();
            break;
        case SCENE_GAMEOVER:
            paintGameOver();
            break;
        case SCENE_HIGHSCORE:
            paintHighscore();
            break;
        case SCENE_SETUMEI:
            paintSetumei();
            break;
        }
    }

    /**
     * �ʐM����ʂ̕`��
     */
    final static void httpRepaint() { /* */ }

    /**
     * ������
     */
    private static final void processInit() {
        switch(count) {
        case 0:
	        DISP_WIDTH  = OS.getWidth();
	        DISP_HEIGHT = OS.getHeight();
	        OS.setOrigin((DISP_WIDTH - WIDTH) / 2,(DISP_HEIGHT - HEIGHT) / 2);
	        OS.clipRect(0, 0, WIDTH, HEIGHT);
	        OS.setFont(0);
	        break;
	    case 1:
	    case 2:
	    case 3:
	        {
	            final int n = count - 1;
	            final byte[] d = OS.loadResource("/sound" + n + ".mld");
	            sounds[n] = OS.getSound(d);
	        }
	        break;
	    case 4: case 5: case 6: case 7: case 8: case 9:
	    case 10: case 11: case 12: case 13: case 14: case 15:
	    case 16: case 17: case 18: case 19: case 20: case 21:
	    case 22: case 23: case 24: case 25: case 26: case 27:
	        {
	        	final int n = count - 4;
	            final byte[] d = OS.loadResource("/" + n + ".gif");
	            image[n]       = OS.getImage(d);
	            imageWidth[n]  = OS.getImageWidth(image[n]);
	            imageHeight[n] = OS.getImageHeight(image[n]);
	        }
	        break;
	    case 28:
	        final byte[] d1 = OS.loadResource("/bs.gif");
	        imageBigNum = OS.getImage(d1);
	        break;
        case 29:
	        final byte[] d2 = OS.loadResource("/ls.gif");
	        imageLitNum = OS.getImage(d2);
	        break;
	    case 30:
	        load();
	        break;
	    case 31:
	        gotoLogo();
	        break;
        }
        count++;
    }

    /**
     * ��������ʂ�`�悷��
     */
    private static final void paintInit() {
        OS.setRGB(0xFFFFFF);
        final String[] a1 = {"��","�^","��","�_"};
        final String a2   = "...";
        final String s    = "loading";
        final String s1   = a1[count%4] +  " " + s;
        OS.drawString(s1 + a2.substring(0,count / 5 % 4),
                      (WIDTH - OS.stringWidth(s1)) / 2,
                      (HEIGHT - OS.fontHeight())  / 2);
    }

    /**
     * ���S��ʂ֑J��
     */
    private final static void gotoLogo() {
        count = 0;
        OS.playSound(sounds[SOUND_LOGO]);
        setScene(SCENE_LOGO);
    }

    /**
     * ���S��ʏ���
     */
    private static final void processLogo() {
        count++;
        if (imageHeight[IMAGE_LOGO]/3 + 5 < count) {
            gotoTitle();
        }
    }

    /**
     * ���S��ʕ`��
     */
    private static final void paintLogo() {
        OS.drawImage(image[IMAGE_LOGO], 
                    (WIDTH  - imageWidth[IMAGE_LOGO] ) / 2, 
                    (HEIGHT - imageHeight[IMAGE_LOGO]) / 2);
        OS.fillRect(0,0, WIDTH, HEIGHT/2 - count*3);
        OS.fillRect(0,HEIGHT/2 + count*3, WIDTH, HEIGHT/2 - count*3);
    }
 
    /**
     * �^�C�g����ʂ֑J��
     */
    private final static void gotoTitle() {
        OS.setSoftkey(SOFTKEY_TITLE);
        select = 0;
        count  = 0;
        setScene(SCENE_TITLE);
    }

    /**
     * �^�C�g��
     */
    private static final void processTitle() {
        if (count < WIDTH / 2 - imageWidth[select + 2] / 2 - 5) {
            count += 5;
        }
        switch(OS.keyEvent) {
        case OS.KEY_UP:
        case OS.KEY_2:
            if (select > 0) {
                select--;
                count = 0;
            }
            OS.repeatKey();
            break;
        case OS.KEY_DOWN:
        case OS.KEY_8:
            if (select < 3) {
                select++;
                count = 0;
            }
            OS.repeatKey();
            break;
        case OS.KEY_SELECT:
        case OS.KEY_5:
            if (select == 0) {
                gotoGame();
            }
            if (select == 1) {
                gotoSetumei();
            }
            if (select == 2) {
                gotoHighscore();
            }
            if (select == 3) {
                OS.openBrowser(URL_HOME);
            }
            OS.clearKeyEvent();
            break;
        case OS.KEY_SOFT2:
            OS.term();
        	break;
        }
    }
    
    /**
     * �^�C�g����ʕ`��
     */
    private static final void paintTitle() {
        OS.drawImage(image[IMAGE_TITLE], WIDTH / 2 - imageWidth[IMAGE_TITLE] / 2, 8);
        OS.drawImage(image[2], WIDTH / 2 - imageWidth[2] / 2, 164);
        OS.drawImage(image[3], WIDTH / 2 - imageWidth[3] / 2, 184);
        OS.drawImage(image[4], WIDTH / 2 - imageWidth[4] / 2, 204);
        OS.drawImage(image[5], WIDTH / 2 - imageWidth[5] / 2, 224);

        OS.setRGB(0xFFFFFF);
        OS.drawLine(0, 170 + select * 20, count, 170 + select * 20);
        OS.drawLine(WIDTH, 170 + select * 20, WIDTH - count, 170 + select * 20);
    }


    /**
     * �Q�[����ʂ֑J��
     */
    private final static void gotoGame() {
        OS.setSoftkey(SOFTKEY_GAME);
        worldTop    = 0;
        worldBottom = HEIGHT;
  
        count  = 0;
        bcount = 0;
        ix     = 120;
        for (int i = 0; i < 30; i++) {
            iy[i] = 100;
        }
        cameraX = ix + WIDTH / 4;
        cameraY = iy[0];
      
        vy        = -3;
        hx[0]     = 400;
        hy[0]     = 100;
        hvar[0]   = HVAR_START;
        holesize  = hvar[0];
        score     = 0;
        haricount = score + 1;
        rank      = 10;
        for (int i = 1; i < 10; i++) {
            makeHari(i);
            haricount++;
        }
        pause     = false;
        setScene(SCENE_GAME);
    }
    
    
    /**
     * ���E�̈ړ��\�ʒu��[
     */
    private static int worldTop;
    /**
     * ���E�̈ړ��\�ʒu���[
     */
    private static int worldBottom;
    /**
     * �J�����ʒu
     */
    private static  int cameraX;
    /**
     * �J�����ʒu
     */
    private static  int cameraY;
    /**
	 * ���E�̈ړ��\�ʒu�̏���̍ŏ��l
     */
	private static final int WORLD_TOP_MIN = -HEIGHT;
	/**
     * ���E�̈ړ��\�ʒu�̏���̍ő�l
     */
	private static final int WORLD_TOP_MAX = -HEIGHT/3;
    /**
	 * ���E�̈ړ��\�ʒu�̉����̍ŏ��l
     */
	private static final int WORLD_BOT_MIN =  HEIGHT + HEIGHT/3;
	/**
     * ���E�̈ړ��\�ʒu�̉����̍ő�l
     */
	private static final int WORLD_BOT_MAX = HEIGHT + HEIGHT;
    
    /**
     * �j�𐶐�����
     * @param num ��������j�ԍ�
     */
    private static final void makeHari(final int num) {
        final int org = num - 1;
        //	X���W
        final int speedup = Math.min((1 + (haricount / 10)) * 4, 41);
        hx[num] = hx[org] + 200 - (Math.abs(rand.nextInt()) % speedup) * 4;
        //	Y���W
        hy[num] = hy[org] + Math.abs(rand.nextInt()) % 61 - 30;
        hy[num] = limit(hy[num],worldTop + 30,worldBottom - 30);                
        //	�j���T�C�Y
        hvar[num] = Math.max(HVAR_START - (haricount / 10),HVAR_MIN);
    }

    /**
     * �Q�[��
     * <h2><��ʗ̈�/h2>
     * ����:		0       �` HEIGHT
     * �^��:		-HEIGHT �` HEIGHT * 2
     * �}�[�W��:	30
     */
    private static final void processGame() {
        final int key = OS.keyEvent();
        if (key == OS.KEY_SOFT1) {
            if (!pause) {
                pause = true;
                OS.playSound(sounds[SOUND_LOGO]);
            } else {
                pause = false;
            }
            OS.clearKeyEvent();
        }
        if (key == OS.KEY_SOFT2) {
            gotoLogo();
            return;
        }
        if (key == OS.KEY_POUND) {
            toggleSound();
            OS.clearKeyEvent();
        }
        
        if (!pause && bcount == 0) {
            //	���̈ړ�
            System.arraycopy(iy, 0, iy, 1, iy.length - 1);
            //	�j�̈ړ�
            for (int i = 9; i >= 0; i--) {
                hx[i] -= 4;
            }
            //	���̐j�̓o��
            if (hx[0] < -5) {
                System.arraycopy(hx, 1, hx, 0, hx.length - 1);
                System.arraycopy(hy, 1, hy, 0, hy.length - 1);
                System.arraycopy(hvar, 1, hvar, 0, hvar.length - 1);
                makeHari(9);
                haricount++;
            }

            if (key == OS.KEY_SELECT || key == OS.KEY_5) {
                vy -= 1;
                if (vy < -8) {
                    vy = -8;
                }
            } else {
                vy += 1;
                if (vy > 8) {
                    vy = 8;
                }
            }
            iy[0] += vy;

            //	�j������
            for (int i = 9; i >= 0; i--) {
                if (hx[i] == 120) {
                    if (iy[0] >= hy[i] + 2 && iy[0] <= hy[i] + 2 + hvar[i]) {
                        score++;
                        OS.playSound(sounds[SOUND_PASS]);
                    } else {
                        bcount = 2;
                    }
                    break;
                }
                if (hx[i] == 240) {
                    holesize = hvar[i];
                }
            }
            
            final int zoom = haricount % 10 * 30;
            worldTop    = limit(-zoom,        WORLD_TOP_MIN,WORLD_TOP_MAX);
            worldBottom = limit(HEIGHT + zoom,WORLD_BOT_MIN,WORLD_BOT_MAX);
	        final int SYT = iy[0] - 16;//WIDTH  / 4;
	        final int SYB = iy[0] + 16;//WIDTH  / 4;   
	        //	�J�����ʒu����ʃZ���^�[��
	        cameraX = ix    + WIDTH / 4;
	        if (cameraY < SYT ) {
	        	cameraY++;
	        }
	        if (SYB < cameraY) {
	        	cameraY--;
	        }
     
            if (count < 20) {
                count++;
            }
        }
        if (1 < bcount) {
            bcount++;
            if (bcount == ANIM_NUM_BAKUHA) {
                gotoGameOver();
            }
        }
    }

    /**
     * �Q�[����ʕ`��
     * RENDER_X = (AX - cameraX) + CENTER_Y
     */
    private static final void paintGame() {
        paintGameObjects();
        //	���ݒ�
        OS.setRGB(0xFFFFFF);
        OS.drawString("��",WIDTH-20,HEIGHT-20);
        if (muteSound) {
            OS.drawString("�^",WIDTH-20,HEIGHT-20);
        }

        //	�|�[�Y��
        if (pause) {
            OS.drawImage(image[7],
                         (WIDTH  - imageWidth[7]) / 2,
                         (HEIGHT - imageHeight[7]) / 2);
        //  �X�^�[�g
        } else if (count < 20) {
            OS.drawImage(image[6],
                         (WIDTH  - imageWidth[6])  / 2,
                         (HEIGHT - imageHeight[6]) / 2);
        }
    }

    /**
     * �Q�[���̊e��I�u�W�F�N�g��`�悷��
     */
    private static final void paintGameObjects() {
//        //	�X�N���[���̈�O
//        OS.setRGB(0x333333);
//        OS.drawLine(0,worldTop    - cameraY + CENTER_Y, WIDTH, worldTop - cameraY + CENTER_Y);
//        OS.drawLine(0,worldBottom - cameraY + CENTER_Y, WIDTH, worldBottom - cameraY + CENTER_Y);
//        OS.drawLine(0,120 - cameraY + CENTER_Y, WIDTH,120 - cameraY + CENTER_Y);
 
        //	��
        OS.setRGB(0xFFFFFF);
        for (int i = 28; i >= 0; i--) {
            final int x0 = (ix - i * 4) - cameraX + CENTER_X;
            final int y0 = iy[i] - cameraY + CENTER_Y;
            final int x1 = (ix - (i+1) * 4) - cameraX + CENTER_X;
            final int y1 = iy[i+1] - cameraY + CENTER_Y;            
            OS.drawLine(x0,y0,x1,y1);
        }
        //	���j
        if (bcount > 1) {
            final int x = (ix    - imageWidth[20 + bcount / 2] / 2)  - cameraX + CENTER_X;
            final int y = (iy[0] - imageHeight[20 + bcount / 2] / 2) - cameraY + CENTER_Y;
            OS.drawImage(image[20 + bcount / 2],x,y);
        }
        
        //	�j
        for (int i = 9; i >= 0; i--) {
            final int hxc = hx[i] - cameraX + CENTER_X;
            final int hyc = hy[i] - cameraY + CENTER_Y;
            if (100 <= hx[i] && hx[i] < 120) {
                OS.setRGB(0xFFFFFF);
                if (scranking[0] > 0 && score == scranking[0] + 1) {
                    OS.drawString("�L�^�X�V", hxc - 24, hyc - 5 - OS.fontHeight());
                }
                if (score % 50 == 0) {
                    OS.drawString(score + "�{�z��",
                                  hx[i] - OS.stringWidth(score + "�{�z��") / 2,
                                  hyc - 5 - OS.fontHeight());
                } else {
                    OS.drawString("OK", hxc - 6, hyc - 5 - OS.fontHeight());
                }
            }
            if (240 < hxc) {
                continue;
            }
            OS.drawImage(image[19], hxc - 2, hyc);
            OS.setRGB(0x000000);
            OS.fillRect(hxc- 1, hyc + 2, 2, hvar[i]);
        }

        //	�w�b�_�[
        OS.drawImage(image[9], 2, 5);
        drawBigNum  (2 + imageWidth[9] + 1,3, score,4,true);
        OS.drawImage(image[10], 115, 0);
        OS.drawImage(image[11], 155, 3);
        drawLitNum  (155 + imageWidth[11] + 3, 5, holesize,2,true);
        OS.drawImage(image[12], 220, 9);
    }

    /**
     * �Q�[���I�[�o��ʕ`��
     */
    private static final void paintGameOver() {
        paintGameObjects();

        OS.drawImage(image[8],
                     (WIDTH  - imageWidth[8]) / 2,
                     (HEIGHT - imageHeight[8]) / 2);
        if (rank < 10) {
            OS.drawImage(image[13], WIDTH / 2 - imageWidth[13] / 2, 180);
            OS.drawImage(image[4], 10, 220);
            OS.drawImage(image[14], 82, 220);
            drawLitNum  (95, 216, rank + 1, 2,false);
            OS.drawImage(image[17], 120, 215);
            OS.drawImage(image[15], 140, 220);
        }
    }
    
    /**
     * �Q�[���I�[�o�[��ʂ֑J��
     */
    private final static void gotoGameOver() {
        updateHiscore();
        OS.setSoftkey(SOFTKEY_GAMEOVER);
        OS.playSound(sounds[SOUND_GAMEOVER]);
        bcount = ANIM_NUM_BAKUHA - 1;
        setScene(SCENE_GAMEOVER);
    }

    /**
     * �Q�[���I�[�o��ʏ���
     */
    private static final void processGameOver() {
        int param = OS.keyEvent();
        switch(param) {
        case OS.KEY_SELECT:
        case OS.KEY_5:
        case OS.KEY_SOFT2:
            gotoTitle();
        	break;
        }
    }

    /**
     * �n�C�X�R�A���X�V����
     */
    private static final void updateHiscore() {
        //	�����L���O���X�V
        for (int i = 0; i < 10; i++) {
            if (score > scranking[i]) {
                System.arraycopy(scranking, i, scranking, i + 1,
                        scranking.length - (i + 1));
                scranking[i] = score;
                rank = i;
                save();
                i = 11;
            }
        }
    }
    
    /**
     * ������ʕ`��
     */
    private static final void paintSetumei() {
        OS.drawImage(image[3], (WIDTH  - imageWidth[3]) / 2, 10);
        OS.setRGB(0xFFFFFF);
        for (int i = 0; i < 12; i++) {
            OS.drawString(SETUMEI[i],
                          (WIDTH - OS.stringWidth(SETUMEI[i])) / 2,
                          10 + imageHeight[3] + 5 + i * (OS.fontHeight() + 3));
        }
    }

    /**
     * ������ʏ���
     */
    private static final void processSetumei() {
        int param = OS.keyEvent();
        if (param == OS.KEY_SOFT1) {
            gotoTitle();
        }
        if (param == OS.KEY_SELECT || param == OS.KEY_5) {
            gotoTitle();
        }
    }

    /**
     * �n�C�X�R�A��ʂ֑J��
     *  
     */
    private final static void gotoHighscore() {
        OS.setSoftkey(SOFTKEY_HIGHSCORE);
        setScene(SCENE_HIGHSCORE);
    }
    
    /**
     * �n�C�X�R�A�`��
     */
    private static final void paintHighscore() {
        OS.drawImage(image[4], WIDTH / 2 - imageWidth[4] / 2, 10);
        for (int i = 0; i < 10; i++) {
            drawLitNum  (26,  27 + (i * 20), i + 1,       2,false);
            OS.drawImage(image[17], 52, 25 + (i * 20));
            drawBigNum  (125, 25 + (i * 20), scranking[i],4,true);
            OS.drawImage(image[18], 190, 25 + (i * 20));
        }
//        final String s = "[�o�^]��ȯ��ݷݸނɎQ���ł��܂��B";
//        OS.setRGB(0xFFFFFF);
//        OS.drawString(s, (WIDTH - OS.stringWidth(s)) / 2, HEIGHT - 3 - OS.fontHeight());
    }

    /**
     * �n�C�X�R�A
     */
    private static final void processHighscore() {
        int param = OS.keyEvent();
        switch(param) {
        case OS.KEY_SOFT1:
        case OS.KEY_SELECT:
        case OS.KEY_5:
            gotoTitle();
            break;
        case OS.KEY_SOFT2:
//            //�����L���Ocgi�Ƀf�[�^�𑗂�Ƃ��ɊȒP�ɈÍ���
//            String[] AStoA = { "w", "c", "t", "q", "z", "p", "l", "o", "y", "n" };
//            String[] BStoA = { "e", "v", "m", "l", "q", "p", "u", "y", "a",
//                    "b", "z", "r", "v", "h", "o", "x", "k", "f", "g" };
//            String sendscore = "";
//            char[] charscore = Integer.toString(scranking[0]).toCharArray();
//            sendscore += AStoA[Integer.parseInt(String
//                    .valueOf(charscore.length))];
//            for (int i = 0; i < charscore.length; i++) {
//                sendscore += AStoA[Integer.parseInt(String
//                        .valueOf(charscore[i]))];
//            }
//            sendscore += BStoA[Integer.parseInt(String.valueOf(charscore[0])) + 9];
//            for (int i = 0; i < charscore.length - 1; i++) {
//                sendscore += BStoA[(Integer.parseInt(String
//                        .valueOf(charscore[i])) - Integer.parseInt(String
//                        .valueOf(charscore[i + 1]))) + 9];
//            }
//            OS.openBrowser("http://satoo.jp/i/itotoosi/r.cgi?a=" + sendscore);
            break;
        }
    }

    /**
     * ������ʂ֑J��
     *  
     */
    private final static void gotoSetumei() {
        OS.setSoftkey(new String[] { "�߂�", null });
        select = 0;
        setScene(SCENE_SETUMEI);
    }


    /**
     * �V�[���ԍ���؂�ւ���
     * 
     * @param nextScene
     *            �؂�ւ���V�[���ԍ�
     */
    private final static void setScene(final int nextScene) {
        scene = nextScene;
        OS.clearKeyEvent();
    }   
    
    /**
     * �l�� min ���� max�܂ł̊Ԃ̒��ɐ��K������B
     * @param v ���K���O�̒l
     * @param min �Ƃ肤��l�̍ŏ��l
     * @param max �Ƃ肤��l�̍ő�l
     * @return ���K����̒l
     */
    private static final int limit(final int v,final int min,final int max) {
        if (v < min) { 
            return min;
        }
        if (max < v) {
            return max;
        }
        return v;
    }

    /**
     * �T�E���h���I��/�I�t����B
     */
    private static final void toggleSound() {
        muteSound = !muteSound;
        OS.setMute(muteSound);
        save();
    }

    /**
     * �傫�Ȑ�����`�悷��
     * 
     * @param kazu
     *            �`�悷�鐔��
     * @param x
     *            �`��ʒuX���W
     * @param y
     *            �`��ʒuY���W
     * @param keta
     *            ��
     * @param padding ����0�ŋl�߂邩�ǂ���
     */
    private static void drawBigNum(final int x, final int y, final int kazu,
            final int keta,final boolean padding) {
        drawNum(imageBigNum,x,y,kazu,keta,padding);
    }

    /**
     * �����Ȑ�����`�悷��
     * 
     * @param kazu
     *            �`�悷�鐔��
     * @param x
     *            �`��ʒuX���W
     * @param y
     *            �`��ʒuY���W
     * @param keta �����ŕ\�L���邩�H
     * @param padding ����0�ŋl�߂邩�ǂ���
     */
    private static void drawLitNum(final int x, final int y, final int kazu,final int keta,final boolean padding) {
        drawNum(imageLitNum,x,y,kazu,keta,padding);
    }

    /**
     * �t�H���g�摜���g��������`�悷��B
     * @param i �t�H���g�摜
     * @param x ������`�悷��ʒu
     * @param y ������`�悷��ʒu
     * @param kazu �`�悷�鐔��
     * @param keta �����ŕ\�L���邩�H
     * @param padding ����0�ŋl�߂邩�ǂ���
     */
    private static void drawNum(final Object i,final int x, final int y, final int kazu,final int keta,final boolean padding) {
        final int iw = OS.getImageWidth(i) / 10;
        final int ih = OS.getImageHeight(i);
        int t   = kazu;
        for (int n = 0;n < keta;n++) {
            final int kazu1 = t % 10;
            if (padding || t != 0) {
	          	OS.drawImage(i,
	              x + (keta - n - 1) * iw,
	              y,
	              kazu1 * iw,
	              0,
	              iw,ih);
            }
            t /= 10;
        }
    }
    
    /**
     * �f�[�^�ۑ�
     */
    private static final void save() {
        final byte[] data = new byte[1 + scranking.length * 4];
        data[0] = (byte) (muteSound ? 1 : 0);

        int pos = 1;
        for (int n = 0; n < scranking.length; n++) {
            final int hiscore = scranking[n];
            data[pos + 0] = (byte) (hiscore & 0xFF);
            data[pos + 1] = (byte) ((hiscore >> 8) & 0xFF);
            data[pos + 2] = (byte) ((hiscore >> 16) & 0xFF);
            data[pos + 3] = (byte) ((hiscore >> 24) & 0xFF);
            pos += 4;
        }
        OS.writeScratchpad(0, data, 0, data.length);
    }

    /**
     * �ǂݍ��ށB
     */
    private static final void load() {
        final byte[] data = new byte[1 + scranking.length * 4];
        OS.readScratchpad(0, data, 0, data.length);
        muteSound = data[0] == 1;
        int pos = 1;
        for (int n = 0; n < scranking.length; n++) {
            final int rank = ((data[pos + 0]) & 0xFF)
                    + (((data[pos + 1]) & 0xFF) >> 8)
                    + (((data[pos + 2]) & 0xFF) >> 16)
                    + (((data[pos + 3]) & 0xFF) >> 24);
            pos += 4;
            scranking[n] = rank;
        }
        OS.setMute(muteSound);
    }
}