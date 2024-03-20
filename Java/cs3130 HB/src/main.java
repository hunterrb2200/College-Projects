//Hunter Beauto
//project 3 part 2
//cs3130
//java file
//credit for geeksforgeeks and tutor help
public class main {
	totalNodes(node,k){
	int n=0;
	if(node==null) {//When node is null or tree is null
	return 0;}
	if(node->key<k) //if the value of the key is less than the k
	n=totalNodes(node->right,k)
	elseif (node->key==k) //if the value of the key is equal to the k
	n=childtreesize(node->right)+1 //take the size of the child tree and add 1 because this node will be counted also.
	else //if the value of the key is greater than the k
	n=childtreesize(node->right)+1 + totalNodes(node->left,k)+1;    //right subtree needs to be included and call the function on the left subtree recursively and add 1 because this node will be counted also.
	return n;
	}
}
