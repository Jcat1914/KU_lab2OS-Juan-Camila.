
/* It is in this file, specifically the replacePage function that will
   be called by MemoryManagement when there is a page fault.  The 
   users of this program should rewrite PageFault to implement the 
   page replacement algorithm.
*/

// This PageFault file is an example of the FIFO Page Replacement 
// Algorithm as described in the Memory Management section.

import java.util.*;
import Page;
import ControlPanel;

public class PageFaultLRU {
  // Find the next page to replace using the least recently used timestamp.
  public static void replacePage(Vector mem, int virtualPageNum, int replacementPage, ControlPanel ControlPanel) {
    int leastRecentlyUsedPage = 0;
    int minLastTouchTime = Integer.MAX_VALUE;

    for (int i = 0; i < virtualPageNum; i++) {
      Page currentPage = (Page) mem.elementAt(i);

      if (currentPage.physical != -1 && currentPage.lastTouchTime < minLastTouchTime) {
        leastRecentlyUsedPage = i;
        minLastTouchTime = currentPage.lastTouchTime;
      }
    }
    Page page = (Page) mem.elementAt(nextReplacementPage);
    Page newPage = (Page) mem.elementAt(replacementPage);

    ControlPanel.removePhysicalPage(nextReplacementPage);
    ControlPanel.addPhysicalPage(nextReplacementPage, replacePageNum);
    pageToReplace.inMemTime = 0;
    pageToReplace.lastTouchTime = 0;
    pageToReplace.R = replacementPage;
    pageToReplace.M = replacementPage;
    pageToReplace.physical = -1;
    newPage.physical = nextReplacementPage;

  }
}
