import java.util.*;
import Page;

public class PageFaultRoundRobin {
  // Find the next page to replace using round-robin algorithm.
  public static void replacePage(Vector mem, int virtualPageNum, int replacementPage, ControlPanel ControlPanel) {
    int nextReplacementPage = 0;

    while (((Page) mem.elementAt(nextReplacementPage)).physical != -1) {
      nextReplacementPage = (nextReplacementPage + 1) % virtualPageNum;
    }
    Page page = (Page) mem.elementAt(nextReplacementPage);

    Page newPage = (Page) mem.elementAt(replacementPage);

    controlPanel.removePhysicalPage(nextReplacementPage);
    controlPanel.addPhysicalPage(nextReplacementPage, replacePageNum);
    pageToReplace.inMemTime = 0;
    pageToReplace.lastTouchTime = 0;
    pageToReplace.R = replacementPage;
    pageToReplace.M = replacementPage;
    pageToReplace.physical = -1;
    newPage.physical = nextReplacementPage;

  }
}
