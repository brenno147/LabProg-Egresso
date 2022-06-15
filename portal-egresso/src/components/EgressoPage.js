import React from "react";
import CardEgresso from "./CardEgresso";

const egressoPage = () => {
    return ( 
        <div class="container mt-5 mb-5">
            <div class="row mt-1">
                <div class="col-md-4">
                    <CardEgresso/>
                </div>

                <div class="col-md-4">
                    <CardEgresso/>
                </div>

                <div class="col-md-4">
                    <CardEgresso/>
                </div>

                <div class="col-md-4">
                    <CardEgresso/>
                </div>

                <div class="col-md-4">
                    <CardEgresso/>
                </div>

                <div class="col-md-4">
                    <CardEgresso/>
                </div>
            </div>

            <div class="d-flex justify-content-end text-right mt-2">
                <nav>
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">4</a></li>
                        <li class="page-item"><a class="page-link" href="#">5</a></li>
                        <li class="page-item"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
                    </ul>
                </nav>
            </div>
        </div>
     );
}
 
export default egressoPage;