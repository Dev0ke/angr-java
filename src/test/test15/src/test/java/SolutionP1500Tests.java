import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP1500Tests {
    @Test
    public void example1() {
        // 我们用该系统分享由 4 个文件块组成的文件。
        SolutionP1500.FileSharing fileSharing = new SolutionP1500.FileSharing(4);

        // 一个拥有文件块 [1,2] 的用户加入系统，为其注册 id = 1 并返回 1。
        Assertions.assertEquals(1, fileSharing.join(List.of(1, 2)));

        // 一个拥有文件块 [2,3] 的用户加入系统，为其注册 id = 2 并返回 2。
        Assertions.assertEquals(2, fileSharing.join(List.of(2, 3)));

        // 一个拥有文件块 [4] 的用户加入系统，为其注册 id = 3 并返回 3。
        Assertions.assertEquals(3, fileSharing.join(List.of(4)));

        // id = 1 的用户请求第 3 个文件块，只有 id = 2 的用户拥有文件块，返回 [2] 。注意，现在用户 1 现拥有文件块 [1,2,3]。
        List<Integer> expected = List.of(2);
        Assertions.assertEquals(expected, fileSharing.request(1, 3));

        // id = 2 的用户请求第 2 个文件块，id 为 [1,2] 的用户拥有该文件块，所以我们返回 [1,2] 。
        expected = List.of(1, 2);
        Assertions.assertEquals(expected, fileSharing.request(2, 2));

        // id = 1 的用户离开系统，其所拥有的所有文件块不再对其他用户可用。
        fileSharing.leave(1);

        // id = 2 的用户请求第 1 个文件块，系统中没有用户拥有该文件块，所以我们返回空列表 [] 。
        expected = List.of();
        Assertions.assertEquals(expected, fileSharing.request(2, 1));

        // id = 2 的用户离开系统。
        fileSharing.leave(2);

        // 一个不拥有任何文件块的用户加入系统，为其注册 id = 1 并返回 1 。注意，id 1 和 2 空闲，可以重新使用。
        Assertions.assertEquals(1, fileSharing.join(List.of()));
    }
}